package jp.co.example.dto.entity;

import java.util.ArrayList;

public class Quiz {
	private Integer quizId;
	private String quizTitle;
	private String quizStatment;
	private Integer correctAnswer;
	private Integer display;
	private String commentary;
	private String categoryName;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;

	private Integer categoryId;
	private ArrayList<QuizSelect> quizSelect;

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public ArrayList<QuizSelect> getQuizSelect() {
		return quizSelect;
	}
	public void setQuizSelect(ArrayList<QuizSelect> quizSelect) {
		this.quizSelect = quizSelect;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
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
		return "Quiz [quizId=" + quizId + ", categoryId=" + ", quizTitle=" + quizTitle + ", quizStatement="
				+ quizStatment + ", correctAnswer=" + correctAnswer + ", commentary=" + commentary + ", display="
				+ display + ", quizSelect=" + ",quizSelect " +"]";
	}


}
