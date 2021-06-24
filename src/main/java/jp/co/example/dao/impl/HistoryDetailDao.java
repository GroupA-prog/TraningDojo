package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.IHistoryDetailDao;
import jp.co.example.dto.entity.HistoryDetail;
import jp.co.example.dto.entity.HistoryDetailDisp;

@Repository
public class HistoryDetailDao implements IHistoryDetailDao {
	//logDetai.jsp用
	//問題数取得
	private final static String SELECT_COUNT_BY_HISTORYID = "SELECT COUNT(*) AS quiz_count FROM history_detail WHERE history_id = :historyId";

	//	//ユーザーが選択したクイズID取得
	//	private final static String SELECT_QUIZID_BY_HISTORYID = "SELECT quiz_id FROM history_detail WHERE history_id = :historyId ORDER BY history_detail_id";

	//comment更新
	private final static String UPDATE_COMMENT = "UPDATE history_detail SET comment = :comment, update_time = :updateTime WHERE history_detail_id = :historyDetailId";

	private final static String SELECT_ALL_BY_HISTORYID = "SELECT * FROM history_detail WHERE history_id = :historyId ORDER BY history_detail_id";

	//ユーザーが選択したクイズ、クイズ選択肢、詳細履歴取得
	private final static String SELECT = "SELECT max(h.history_id) AS history_id ,max(hd.quiz_id) AS quiz_id ,max(hd.comment) AS comment ,max(hd.history_detail_id) AS history_detail_id ,max(hd.user_answer) AS user_answer ,max(q.quiz_statment) AS quiz_statment ,max(q.correct_answer) AS correct_answer ,max(q.commentary) AS commentary ,max( CASE WHEN qs.quiz_choice_id = 1 THEN qs.choice ELSE NULL END) AS choice1 ,max( CASE WHEN qs.quiz_choice_id = 2 THEN qs.choice ELSE NULL END) AS choice2 ,max( CASE WHEN qs.quiz_choice_id = 3 THEN qs.choice ELSE NULL END) AS choice3 ,max( CASE WHEN qs.quiz_choice_id = 4 THEN qs.choice ELSE NULL END) AS choice4 ,max( CASE WHEN hd.user_answer = 1 THEN 'checked' ELSE '' END) AS checked1 ,max( CASE WHEN hd.user_answer = 2 THEN 'checked' ELSE '' END) AS checked2 ,max( CASE WHEN hd.user_answer = 3 THEN 'checked' ELSE '' END) AS checked3 ,max( CASE WHEN hd.user_answer = 4 THEN 'checked' ELSE '' END) AS checked4 ,max( CASE WHEN  q.correct_answer = 1 THEN 'correct' ELSE '' END) AS correct1 ,max( CASE WHEN  q.correct_answer = 2 THEN 'correct' ELSE '' END) AS correct2 ,max( CASE WHEN  q.correct_answer = 3 THEN 'correct' ELSE '' END) AS correct3 ,max( CASE WHEN  q.correct_answer = 4 THEN 'correct' ELSE '' END) AS correct4 ,ROW_NUMBER() OVER(ORDER BY hd.history_detail_id ASC) AS row_number FROM history h JOIN history_detail hd ON h.history_id = hd.history_id JOIN quiz q ON hd.quiz_id = q.quiz_id JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE h.history_id = :historyId GROUP BY hd.history_detail_id, h.history_id, hd.quiz_id";

	//更新した時間取得
	private final static String SELECT_UPDATE_TIME = "SELECT MAX(update_time) AS update_time FROM history_detail where history_id = :historyId";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//logDetail.jsp>>問題数取得
	public Integer countByHistoryId(Integer historyId) {
		String sql = SELECT_COUNT_BY_HISTORYID;

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("historyId", historyId);

		return jdbcTemplate.queryForObject(sql, param, Integer.class);
	}

	//	//logDetail.jsp>>ユーザーが解いたクイズID取得
	//	public List<Integer> findQuizIdByHistoryId(Integer historyId) {
	//		String sql = SELECT_QUIZID_BY_HISTORYID;
	//
	//		MapSqlParameterSource param = new MapSqlParameterSource();
	//
	//		param.addValue("historyId", historyId);
	//
	//		List<Integer> list = new ArrayList<Integer>();
	//
	//		list = jdbcTemplate.queryForList(sql, param, Integer.class);
	//
	//		for (int i = 0; i < list.size(); i++) {
	//			System.out.println(list.get(i));
	//		}
	//
	//		return list;
	//	}

	//logDetail.jsp>>comment更新
	public void updateComment(String comment, Integer historyDetailId, Timestamp updateTime) {
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("comment", comment);
		param.addValue("historyDetailId", historyDetailId);
		param.addValue("updateTime", updateTime);

		jdbcTemplate.update(UPDATE_COMMENT, param);
	}

	public List<HistoryDetail> findAllByHistoryId(Integer historyId) {
		String sql = SELECT_ALL_BY_HISTORYID;

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("historyId", historyId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<HistoryDetail>(HistoryDetail.class));
	}

	//logDetai.jsp>>クイズ問題文、選択肢、解説、コメント表示？
	public List<HistoryDetailDisp> findHistoryDetailDisp(Integer historyId) {
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("historyId", historyId);

		return jdbcTemplate.query(SELECT, param, new BeanPropertyRowMapper<HistoryDetailDisp>(HistoryDetailDisp.class));
	}

	//logList.jsp>>更新時間表示
	public Timestamp findUpdateTimeByHistoryId(Integer historyId) {
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("historyId", historyId);

		return jdbcTemplate.queryForObject(SELECT_UPDATE_TIME, param, Timestamp.class);
	}
}
