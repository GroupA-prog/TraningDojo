package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.IHistoryDao;
import jp.co.example.dto.entity.History;
import jp.co.example.service.IHistoryService;

@Service
public class HistoryService implements IHistoryService{
	@Autowired
	IHistoryDao iHDao;

	public List<History> findByLoginIdAndCategoryId(Integer userId, Integer categoryId){
		return iHDao.findByLoginIdAndCategoryId(userId, categoryId);
	}

	//logDetail.jsp用
	public List<History> findRowNumberByhistoryId(Integer userId, Integer categoryId, Integer historyId){
		return iHDao.findRowNumberByhistoryId(userId, categoryId,historyId);
	}

}
