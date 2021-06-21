package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.Category;

public interface ICategoryDao {
	public List<Category> selectAll();
	public int insert(String categoryName, Integer display, Integer parentCategoryId);
	public int update(Integer categoryId, String categoryName, Integer display, Integer parentCategoryId);
	public List<Category> findByCategoryName(String categoryName);
	public List<Category> findByCategoryId(Integer categoryId);
}
