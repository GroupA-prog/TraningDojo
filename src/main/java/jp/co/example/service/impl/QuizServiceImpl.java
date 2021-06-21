package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.service.QuizService;

@Repository
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizDao quizDao;

	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum){
		return quizDao.findByCategoryQuiz(categoryId, quizNum);
	}


	public List<Quiz> findByRankCategory(Integer categoryId){
		return quizDao.findByRankCategory(categoryId);
	}


	@Override
	public List<Quiz> findByQuizTitle(String quizTitle) {
		return quizDao.findByQuizTitle(quizTitle);
	}

	@Override
	public int insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display) {
		return quizDao.insertQuiz(categoryId, quizTitle, quizStatment, correctAnswer, commentary, display);
	}

}
