package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.IQuizSelectDao;
import jp.co.example.service.IQuizSelectService;

@Service
public class QuizSelectService implements IQuizSelectService {
	@Autowired
	IQuizSelectDao quizSelectDao;

	@Override
	public int insertQuizSelect(Integer quizId, Integer choiceId, String choice) {
		return quizSelectDao.insertQuizSelect(quizId, choiceId, choice);
	}

}
