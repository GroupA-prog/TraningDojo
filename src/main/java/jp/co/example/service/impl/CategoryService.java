package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.ICategoryDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.ICategoryService;

@Transactional
@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public List<Category> selectAll() {
		return categoryDao.selectAll();
	}

	public List<Category> selectParentCategory() {
		List<Category> list = categoryDao.selectAll();
		return list;
	}

	public int insert(String categoryName, Integer display, Integer parentCategoryId) {
		return categoryDao.insert(categoryName, display, parentCategoryId);
	}


	public int update(Integer categoryId, String categoryName, Integer display, Integer parentCategoryId) {
		return categoryDao.update(categoryId, categoryName, display, parentCategoryId);
	}

	public List<Category> findByCategoryName(String categoryName) {
		List<Category> list = categoryDao.findByCategoryName(categoryName);
		return list;
	}

	public List<Category> findByCategoryId(Integer categoryId) {
		return categoryDao.findByCategoryId(categoryId);
	}

}
