package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Category;

public interface QuizConfigService {

	public List<Category> categoryNameAll();
	public int categoryNum(String categoryName);

}
