package jp.co.example.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.example.dto.entity.Ranking;
import jp.co.example.dto.entity.RankingCategory;

public interface IRankingService {
	public List<RankingCategory> selectAll();

	public RankingCategory selectByCategoryId(Integer categoryId);

	public ArrayList<Ranking> makeRanking(Integer categoryId);

	public Ranking searchMyData(ArrayList<Ranking> rankingList, Integer userId);

	public int rankingUserNum(Integer categoryId);

	public int searchRankTen(ArrayList<Ranking> rankingList);
}
