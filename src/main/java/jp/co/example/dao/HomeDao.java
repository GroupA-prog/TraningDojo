package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Home;

public interface HomeDao {
	public List<Category> parentCategoryAll();
	public List<Home> answerLateList(Integer categoryId);
	public List<Home> fullCategory(Integer categoryId);

}
