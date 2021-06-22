package jp.co.example.service;

import jp.co.example.controller.form.AdminForm;
import jp.co.example.dto.entity.Quiz;

public interface IQuizSelectService {
	public int insertQuizSelect(Integer quizId, Integer choiceId, String choice);
	public void insertAll(AdminForm form, Quiz quiz);
	public void updateAll(AdminForm form, Quiz quiz);
}
