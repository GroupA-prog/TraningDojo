package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.Quiz;

public interface QuizDao {
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<Quiz> findByRankCategory(Integer categoryId);
}
