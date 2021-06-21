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

	@Override
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum){
		return quizDao.findByCategoryQuiz(categoryId, quizNum);
	}
	@Override
	public List<Quiz> findByRankCategory(Integer categoryId){
		return quizDao.findByRankCategory(categoryId);
	}

	@Override
	public String selectMode(Integer modeId) {
		if(modeId == 1) {
			return "学習";
		}else {
			return "ランキング";
		}

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
