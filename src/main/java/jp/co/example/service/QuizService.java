package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Quiz;

public interface QuizService {
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<Quiz> findByRankCategory(Integer categoryId);
	public List<Quiz> findByQuizTitle(String quizTitle);
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/GroupA-prog/TraningDojo.git
	public String selectMode(Integer modeId);
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/GroupA-prog/TraningDojo.git
	public List<Quiz> insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
}
