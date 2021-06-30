package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.QuizJoinQuizSelect;
import jp.co.example.dto.entity.QuizResult;

public interface QuizDao {

	public int insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public List<Quiz> findByQuizTitle(Integer categoryId, String quizTitle);
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<Quiz> findByRankCategory(Integer categoryId);
	public List<Quiz> findByCategoryId(Integer categoryId);
	public List<QuizJoinQuizSelect> findByQuizId(Integer quizId);
	public int updateQuiz(Integer quizId, Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public int insertHistory(QuizResult quizResult);
	public void insertHistoryDetail(List<QuizResult>quizResult,Integer historyId);
	public int findByCorrect(Integer historyId);
}
