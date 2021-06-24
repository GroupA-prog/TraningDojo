package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.IRankingDao;
import jp.co.example.dto.entity.Ranking;
import jp.co.example.dto.entity.RankingCategory;
import jp.co.example.service.IRankingService;

@Transactional
@Service
public class RankingService implements IRankingService {
	@Autowired
	private IRankingDao rankingDao;

	@Override
	public List<RankingCategory> selectAll() {
		return rankingDao.selectAll();
	}

	@Override
	public RankingCategory selectByCategoryId(Integer categoryId) {
		return rankingDao.selectByCategoryId(categoryId);
	}

	@Override
	public ArrayList<Ranking> makeRanking(Integer categoryId) {
		return rankingDao.makeRanking(categoryId);
	}

	@Override
	public Ranking searchMyData(ArrayList<Ranking> rankingList, Integer userId) {
		return rankingDao.searchMyData(rankingList, userId);
	}

	@Override
	public int rankingUserNum(Integer categoryId) {
		return rankingDao.rankingUserNum(categoryId);
	}

	@Override
	public int searchRankTen(ArrayList<Ranking> rankingList) {
		return rankingDao.searchRankTen(rankingList);
	}

}
