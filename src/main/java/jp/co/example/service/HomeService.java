package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Home;

public interface HomeService {

	public List<Category> parentCategoryAll();
	public List<Home> answerLateList(Integer categoryId);

}
