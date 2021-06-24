package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.History;

public interface IHistoryService {
	public List<History> findByLoginIdAndCategoryId(Integer userId, Integer categoryId);

	//logDetail.jsp用
	public List<History> findRowNumberByhistoryId(Integer historyId);
}
