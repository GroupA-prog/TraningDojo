package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.QuizJoinQuizSelect;
import jp.co.example.dto.entity.QuizSelect;
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
	public int selectModeId(String mode) {
		if(mode.equals("学習")) {
			return 1;
		}else {
			return 2;
		}

	}


	@Override
	public List<Quiz> findByQuizTitle(Integer categoryId, String quizTitle) {
		return quizDao.findByQuizTitle(categoryId, quizTitle);
	}

	@Override
	public Quiz insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display) {
		quizDao.insertQuiz(categoryId, quizTitle, quizStatment, correctAnswer, commentary, display);

		List<Quiz> list =  findByQuizTitle(categoryId, quizTitle);
		return list.isEmpty() ? null : list.get(0);
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

	//答え合わせメソッド
	@Override
	public List<Integer> scoring(List<List<Quiz>> quizList,List<List<Integer>> answerList){
		List<Integer> correct = new ArrayList<Integer>();
		for(List<Quiz> quiz: quizList) {
			for(Quiz q: quiz) {
				for(List<Integer> answer: answerList) {
					for(Integer a: answer) {
						if(a == q.getCorrectAnswer()) {
							correct.add(1);
						}else {
							correct.add(0);
						}
					}
				}
			}
		}
		return correct;
	}

	public Quiz findByQuizId(Integer quizId) {
		List<QuizJoinQuizSelect> list = quizDao.findByQuizId(quizId);
		Quiz quiz = new Quiz();

		if (!list.isEmpty()) {
			QuizJoinQuizSelect qs = list.get(0);
			quiz.setQuizId(qs.getQuizId());
			quiz.setCategoryId(qs.getCategoryId());
			quiz.setQuizTitle(qs.getQuizTitle());
			quiz.setQuizStatment(qs.getQuizStatment());
			quiz.setCorrectAnswer(qs.getCorrectAnswer());
			quiz.setCommentary(qs.getCommentary());
			quiz.setDisplay(qs.getDisplay());

			ArrayList<QuizSelect> quizSelectList = new ArrayList<QuizSelect>();
			for ( QuizJoinQuizSelect q : list ) {
				QuizSelect quizSelect = new QuizSelect();
				quizSelect.setQuizId(q.getQuizId());
				quizSelect.setQuizChoiceId(q.getQuizChoiceId());
				quizSelect.setChoice(q.getChoice());
				quizSelectList.add(quizSelect);
			}
			quiz.setQuizSelect(quizSelectList);
		}

		return quiz;
	}

	@Override
	public List<Quiz> findByCategoryId(Integer categoryId) {
		return quizDao.findByCategoryId(categoryId);
	}

	@Override
	public int updateQuiz(Integer quizId, Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display) {
		return quizDao.updateQuiz(quizId, categoryId, quizTitle, quizStatment, correctAnswer, commentary, display);
	}


}
