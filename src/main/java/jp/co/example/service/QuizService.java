package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Quiz;

public interface QuizService {
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum);

	public List<Quiz> findByRankCategory(Integer categoryId);
}
