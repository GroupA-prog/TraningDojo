package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Category;

public interface ICategoryService {
	public List<Category> selectAll();
	public List<Category> selectAllDisplay();
	public List<Category> selectParentCategory();
	public int insert(String categoryName, Integer display, Integer parentCategoryId);
	public int update(Integer categoryId, String categoryName, Integer display, Integer parentCategoryId);
	public List<Category> findByCategoryName(String categoryName);
	public List<Category> findByCategoryId(Integer categoryId);
}
