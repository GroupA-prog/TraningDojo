package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.example.dao.QuizConfigDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.QuizConfigService;

public class QuizConfigServiceImpl implements QuizConfigService {

	@Autowired
	private QuizConfigDao quizConfigDao;

	public List<Category> categoryNameAll() {

		return quizConfigDao.categoryNameAll();
	}

}
