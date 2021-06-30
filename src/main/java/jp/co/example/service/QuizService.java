package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.QuizResult;

public interface QuizService {
	public List<List<Quiz>> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<List<Quiz>> findByRankCategory(Integer categoryId);
	public List<List<Integer>> answerList(Integer quizNum);
	public void answerUpdate(List<List<Integer>> answer,Integer quizIndex, List<Integer> choiceId);
	public void choiceUpdate(List<Integer> choiceList, Integer choice1,Integer choice2,Integer choice3,Integer choice4,Integer choice5);
	public void setQuiz(List<QuizResult>correctList,List<List<Quiz>> quizList,List<List<Integer>>answerList);
	public List<Quiz> findByQuizTitle(Integer categoryId, String quizTitle);
	public String selectMode(Integer modeId);
	public int selectModeId(String mode);
	public Quiz insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public List<Quiz> findByCategoryId(Integer categoryId);
	public Quiz findByQuizId(Integer quizId);
	public int updateQuiz(Integer quizId, Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public int insertHistory(QuizResult quizresult);
	public void insertHistoryDetail(List<QuizResult>quizResult,Integer historyId);
	public int findByCorrect(Integer historyId);
}
