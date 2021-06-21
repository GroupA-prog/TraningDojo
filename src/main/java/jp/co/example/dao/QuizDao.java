package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.Quiz;

public interface QuizDao {

	public int insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public List<Quiz> findByQuizTitle(String quizTitle);
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<Quiz> findByRankCategory(Integer categoryId);
}
