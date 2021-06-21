package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.service.QuizService;

public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizDao quizDao;

	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum){
		return quizDao.findByCategoryQuiz(categoryId, quizNum);
	}

	public List<Quiz> findByRankCategory(Integer categoryId){
		return quizDao.findByRankCategory(categoryId);
	}

}
