package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.service.QuizService;

@Transactional
@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizDao quizDao;

	@Override
	public List<List<Quiz>> findByCategoryQuiz(Integer categoryId, Integer quizNum){
		List<Quiz> quizList = quizDao.findByCategoryQuiz(categoryId, quizNum);
		List<List<Quiz>> quiz = chopped(quizList,5);
		return quiz;
	}
	@Override
	public List<List<Quiz>> findByRankCategory(Integer categoryId){
		List<Quiz> quizList =  quizDao.findByRankCategory(categoryId);
		List<List<Quiz>> quiz = chopped(quizList,5);
		return quiz;
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
	public List<Quiz> insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display) {
		quizDao.insertQuiz(categoryId, quizTitle, quizStatment, correctAnswer, commentary, display);
		return findByQuizTitle(quizTitle);
	}

	//List分割メソッド
	private static <T> List<List<T>> chopped(List<T> list, final int L) {
	    List<List<T>> parts = new ArrayList<List<T>>();
	    final int N = list.size();
	    for (int i = 0; i < N; i += L) {
	        parts.add(new ArrayList<T>(
	            list.subList(i, Math.min(N, i + L)))
	        );
	    }
	    return parts;
	}

	//問題数を求めるメソッド
	@Override
	public int ListSize(List<List<Quiz>> quizList) {
		int size = 0;
		for(List<Quiz> quiz: quizList) {
			size += quiz.size();
		}
		return size;
	}

	//answerList作成メソッド
	@Override
	public List<List<Integer>> answerList(Integer maxSize){
		List<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i < maxSize; i++) {
			answer.add(0);
		}
		List<List<Integer>>answerList = chopped(answer,5);
		return answerList;
	}

	//answerList更新メソッド
	@Override
	public void answerUpdate(List<List<Integer>> answer,Integer quizIndex, List<Integer> choiceId){
		for(int i = 0; i < choiceId.size();i++) {
			answer.get(quizIndex).set(i,choiceId.get(i));
		}
	}
}
