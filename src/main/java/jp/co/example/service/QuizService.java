package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.Quiz;

public interface QuizService {
	public List<List<Quiz>> findByCategoryQuiz(Integer categoryId, Integer quizNum);
	public List<List<Quiz>> findByRankCategory(Integer categoryId);
	public int ListSize(List<List<Quiz>>quizList);
	public List<List<Integer>> answerList(Integer maxSize);
	public void answerUpdate(List<List<Integer>> answer,Integer quizIndex, List<Integer> choiceId);
	public List<Quiz> findByQuizTitle(Integer categoryId, String quizTitle);
	public List<Integer> scoring(List<List<Quiz>> quizList,List<List<Integer>> answerList);
	public String selectMode(Integer modeId);
	public Quiz insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display);
	public List<Quiz> findByCategoryId(Integer categoryId);
	public Quiz findByQuizId(Integer quizId);
}
