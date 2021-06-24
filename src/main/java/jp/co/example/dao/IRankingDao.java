package jp.co.example.dao;

import java.util.ArrayList;
import java.util.List;

import jp.co.example.dto.entity.Ranking;
import jp.co.example.dto.entity.RankingCategory;

public interface IRankingDao {
	public List<RankingCategory> selectAll();

	public RankingCategory selectByCategoryId(Integer categoryId);

	public ArrayList<Ranking> makeRanking(Integer categoryId);

	public Ranking searchMyData(ArrayList<Ranking> rankingList, int loginUserId);

	public int rankingUserNum(Integer categoryId);

}
