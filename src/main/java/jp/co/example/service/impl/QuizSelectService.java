package jp.co.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.controller.form.AdminForm;
import jp.co.example.dao.IQuizSelectDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.service.IQuizSelectService;

@Service
public class QuizSelectService implements IQuizSelectService {
	@Autowired
	IQuizSelectDao quizSelectDao;

	@Override
	public int insertQuizSelect(Integer quizId, Integer choiceId, String choice) {
		return quizSelectDao.insertQuizSelect(quizId, choiceId, choice);
	}

	@Override
	public void insertAll(AdminForm form, Quiz quiz) {
		ArrayList<String> list = new ArrayList<String>();

		list.add(form.getCreateChoice1());
		list.add(form.getCreateChoice2());
		list.add(form.getCreateChoice3());
		list.add(form.getCreateChoice4());

		for(int i = 0; i < list.size(); i++) {
			quizSelectDao.insertQuizSelect(quiz.getQuizId(), i + 1, list.get(i));
		}
	}

}
