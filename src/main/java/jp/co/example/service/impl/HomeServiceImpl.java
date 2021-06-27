package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.HomeDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Home;
import jp.co.example.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;

	@Override
	public List<Category> parentCategoryAll() {
		return homeDao.parentCategoryAll();
	}

	public List<Home> answerLateList(Integer categoryId){
		return homeDao.answerLateList(categoryId);
	}

	public List<Home> fullCategory(Integer categoryId){
		return homeDao.fullCategory(categoryId);
	}
}
