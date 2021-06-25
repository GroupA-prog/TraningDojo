package jp.co.example.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.IRankingDao;
import jp.co.example.dto.entity.Ranking;
import jp.co.example.dto.entity.RankingCategory;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.util.RankingComparator;

/* ------------------------------------------------
 * ～メソッドの説明～
 * ・searchAll 			 → カテゴリテーブルから最上位カテゴリ（Java,DBなど）を全て取得
 * ・selectByCategoryId  → カテゴリIDを引数にカテゴリ名を取得する
 * ・makeRanking 		 → ランキングを作成する
 * ・rateCalc 			 → 正答率の計算をする
 * ・rankingGetUserId 	 → ランキングに登録されているuserIdを取得
 * ・rankingGetHistoryId → userIdを引数にそのユーザーの直近五回分のHitoryIdを取得
 * ・selectByUserName 	 → userIdからuserNameを取得
 * ・searchMyData 		 → 自分の順位とスコアを調べる
 * ・rankingUserNum 	 → ランキングに登録されている人数を調べる（カテゴリごと）
 * ・searchRankTen		 → １０位の中の最後の人の添字を調べる
 *
 * ------------------------------------------------ */


@Repository
public class RankingDao implements IRankingDao {
	private static final String SELECT = "SELECT * FROM category WHERE parent_category_id IS NULL ORDER BY category_id";
	private static final String SELECT_BY_CATEGORY_ID = "SELECT * FROM category WHERE category_id = :categoryId";
	private static final String RANKING_USER_NUM = "select count(distinct user_id) from history where user_id IN (SELECT user_id FROM history where mode=2 AND category_id=:categoryId group by user_id)";
	private static final String RANKING_USER_ID = "SELECT user_id FROM history where mode=2 AND category_id=:categoryId group by user_id";
	private static final String USER_HISTORY_ID = "SELECT history_id FROM history where mode=2 AND category_id=:categoryId AND user_id = :userId ORDER BY history_date desc LIMIT 5";
	private static final String CORRECT_NUM = "select count(*) from history_detail where history_id=:historyId AND correct=1";
	private static final String SELECT_BY_USER_ID = "SELECT user_name FROM user_info WHERE user_id = :userId";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
//	@Autowired
//	private HttpSession session;


	@Override
	public List<RankingCategory> selectAll() {
		List<RankingCategory> list = jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<RankingCategory>(RankingCategory.class));
		return list;
	}

	@Override
	public RankingCategory selectByCategoryId(Integer categoryId) {

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);

		List<RankingCategory> resultList = jdbcTemplate.query(SELECT_BY_CATEGORY_ID, param, new BeanPropertyRowMapper<RankingCategory>(RankingCategory.class));

		RankingCategory categoryName = resultList.get(0);

		return  categoryName;
	}



	// ランキングを作成するメソッド
	@Override
	public ArrayList<Ranking> makeRanking(Integer categoryId) {

		// ランキング入れる用リスト
		ArrayList<Ranking> rankingList = new ArrayList<Ranking>();

		// ランキング登録済みユーザーIDのリスト
		List<Integer> userList = rankingGetUserId(categoryId);

		if(userList.isEmpty() || userList.size() == 0) {
			rankingList = null;
		}else {
			// ランキング作成
			for(int i=0; i<userList.size(); i++) {
				int userId = userList.get(i);
				int rank = 1;
				String userName = selectByUserName(userId);

				List<Integer> userHistoryId = rankingGetHistoryId(categoryId, userId);	// 直近五回分のHistoryId
				List<Double> scoreList = new ArrayList<Double>();	// 直近五回分の正答率を格納するためのリスト

				// 一回ごとの正答率を計算し、それぞれの正答率をscoreListに格納する
				for(int j=0; j<userHistoryId.size(); j++) {
					scoreList.add(rateCalc(userHistoryId.get(j)));
				}

				// 五回分の正答率（scoreList）の平均を計算
				double total = 0;
				for(int k=0; k<scoreList.size(); k++) {
					total += scoreList.get(k);
				}
				double rankScore = total/scoreList.size();

				// ランキング用オブジェクト(個人データ）をrankingListに保存
				Ranking userData = new Ranking(rank, userId, userName, rankScore);
				rankingList.add(userData);

			}

			//ここから順位付けをする
			//Comparatorクラスの条件(スコア降順）に従いソートする
	        Collections.sort(rankingList, new RankingComparator());

	        // ランク付け
	        int rank = 1;
			for (int i = 1; i < rankingList.size(); i++) {
				double score1 = rankingList.get(i).getScore();
				double score2 = rankingList.get(i-1).getScore();
				if (score1 != score2) {
					// 点数が前の人と違うなら、通し番号を設定
					rank = i + 1;
					rankingList.get(i).setRank(rank);
				}else {
					rankingList.get(i).setRank(rank);
				}
			}
		}// else ランキング作成終了

		return rankingList;

	}


	// 正答率の計算をするメソッド
	public double rateCalc(Integer historyId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("historyId", historyId);
		int correctCount = jdbcTemplate.queryForObject(CORRECT_NUM, param,Integer.class).intValue();
		double score = correctCount / 10.0 * 100;
		return score;
	}

	// ランキングに登録されているユーザーIDを取得
	public List<Integer> rankingGetUserId(Integer categoryId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		List<Integer> userList = jdbcTemplate.queryForList(RANKING_USER_ID, param, Integer.class);
		return  userList;
	}

	// Userの直近五回のhistoryIDを取得（最大五個）
	public List<Integer> rankingGetHistoryId(Integer categoryId, Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		param.addValue("userId", userId);
		List<Integer> historyList = jdbcTemplate.queryForList(USER_HISTORY_ID, param, Integer.class);
		return  historyList;
	}

	// userIdからuserNameを取得する
	public String selectByUserName(Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		UserInfo user = jdbcTemplate.query(SELECT_BY_USER_ID, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class)).get(0);
		return  user.getUserName();
	}


	// 自分が何位なのかとスコアを調べるメソッド
	@Override
	public Ranking searchMyData(ArrayList<Ranking> rankingList, int loginUserId) {

		for(int i=0; i<rankingList.size(); i++) {
			Ranking data = rankingList.get(i);

			if(data.getUserId() == loginUserId) {
				int myRank = data.getRank();
				Double myScore = data.getScore();
				return new Ranking(myRank, myScore);
			}
		}
		// 自分のデータがない時はnullを返す
		return null;
	}

	// ランキング登録者数を数える → カテゴリごとに数える
	@Override
	public int rankingUserNum(Integer categoryId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		int rankingUserNum = jdbcTemplate.queryForObject(RANKING_USER_NUM, param,Integer.class).intValue();
		return rankingUserNum;
	}

	// 最後のrank=10の最後の添え字が何なのかを調べる
	public int searchRankTen(ArrayList<Ranking> rankingList) {
		int rank10 = -1;
		for(int i=0; i<rankingList.size(); i++) {
			Ranking data = rankingList.get(i);

			/* 10位が複数いた時はその都度、変数rank10が更新されていくので
			 * 最後の人の添え字が最終的に格納される*/
			if(data.getRank() == 10) {
				rank10 = rankingList.indexOf(data);
			}

			if(data.getRank() >= 11) {
				break;
			}
		}
		return rank10;
	}

}
