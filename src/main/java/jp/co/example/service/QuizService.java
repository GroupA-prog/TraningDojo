package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Quiz;

public interface QuizService {
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<Quiz> findByRankCategory(Integer categoryId);
	public List<Quiz> findByQuizTitle(String quizTitle);
	public String selectMode(Integer modeId);
	public List<Quiz> insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public List<Quiz> findByCategoryId(Integer categoryId);
	public Quiz findByQuizId(Integer quizId);
}
