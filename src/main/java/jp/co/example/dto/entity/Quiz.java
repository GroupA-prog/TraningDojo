package jp.co.example.dto.entity;

import java.util.ArrayList;

public class Quiz {
	private Integer quizId;
	private Integer categoryId;
	private String quizTitle;
	private String quizStatment;
	private Integer correctAnswer;
	private String commentary;
	private Integer display;
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
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getQuizStatment() {
		return quizStatment;
	}
	public void setQuizStatment(String quizStatement) {
		this.quizStatment = quizStatement;
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
				+ quizStatment + ", correctAnswer=" + correctAnswer + ", commentary=" + commentary + ", display="
				+ display + ", quizSelect=" + quizSelect + "]";
	}


}
