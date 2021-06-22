package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.QuizJoinQuizSelect;
import jp.co.example.dto.entity.QuizSelect;
import jp.co.example.service.QuizService;

//@Transactional
//@Service
public class QuizServiceTsukayama implements QuizService {

	@Autowired
	private QuizDao quizDao;

	@Override
	public List<Quiz> findByCategoryQuiz(Integer categoryId, Integer quizNum){
		return quizDao.findByCategoryQuiz(categoryId, quizNum);
	}
	@Override
	public List<Quiz> findByRankCategory(Integer categoryId){
		return quizDao.findByRankCategory(categoryId);
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

	public List<Quiz> findByCategoryId(Integer categoryId) {
		return quizDao.findByCategoryId(categoryId);
	}

	public Quiz findByQuizId(Integer quizId) {
		List<QuizJoinQuizSelect> list = quizDao.findByQuizId(quizId);
		QuizJoinQuizSelect qs = list.get(0);

		Quiz quiz = new Quiz();
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

		return quiz;
	}

}
