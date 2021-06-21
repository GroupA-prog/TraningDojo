package jp.co.example.dto.entity;

import java.util.ArrayList;

public class Quiz {
	private Integer quizId;
	private Integer categoryId;
	private String quizTitle;
	private String quizStatement;
	private Integer correctAnswer;
	private String commentary;
	private Integer display;
	private Integer quizChoiceId;
	private String choice;
	private Integer userAnswer;
	private ArrayList<QuizSelect> quizSelect;


	public ArrayList<QuizSelect> getQuizSelect() {
		return quizSelect;
	}
	public void setQuizSelect(ArrayList<QuizSelect> quizSelect) {
		this.quizSelect = quizSelect;
	}
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
	public Integer getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(Integer userAnswer) {
		this.userAnswer = userAnswer;
	}
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getQuizChoiceId() {
		return quizChoiceId;
	}
	public void setQuizChoiceId(Integer quizChoiceId) {
		this.quizChoiceId = quizChoiceId;
	}
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getQuizStatement() {
		return quizStatement;
	}
	public void setQuizStatement(String quizStatement) {
		this.quizStatement = quizStatement;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", categoryId=" + categoryId + ", quizTitle=" + quizTitle + ", quizStatement="
				+ quizStatement + ", correctAnswer=" + correctAnswer + ", commentary=" + commentary + ", display="
				+ display + ", quizChoiceId=" + quizChoiceId + ", choice=" + choice + ", userAnswer=" + userAnswer
				+ ", quizSelect=" + quizSelect + "]";
	}


}
