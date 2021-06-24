package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.History;

public interface IHistoryDao {
	//logList.jsp>>カテゴリ名取得用
	public List<History> findByLoginIdAndCategoryId(Integer userId, Integer categoryId);

	//logDetail.jsp>>回数表示用
	public List<History> findRowNumberByhistoryId(Integer historyId);
}
