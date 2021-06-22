package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.QuizConfigDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.QuizConfigService;

@Service
public class QuizConfigServiceImpl implements QuizConfigService {

	@Autowired
	private QuizConfigDao quizConfigDao;

	public List<Category> categoryNameAll() {

		return quizConfigDao.categoryNameAll();
	}

	public int categoryNum(Integer categoryId) {

		return quizConfigDao.categoryNum(categoryId);
	}

}
