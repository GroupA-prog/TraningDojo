package jp.co.example.controller.form;

public class QuizForm{

	private Integer quizId;
	private Integer categoryId;
	private String quizTitle;
	private String quizStatement;
	private Integer correctAnswer;
	private String commentary;
	private Integer display;
	private Integer quizChoiceId;
	private String choice;
	private Integer mode;
	private String categoryName;
	private Integer quizNum;

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
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public String getQuizStatement() {
		return quizStatement;
	}
	public void setQuizStatement(String quizStatement) {
		this.quizStatement = quizStatement;
	}
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
	public Integer getQuizChoiceId() {
		return quizChoiceId;
	}
	public void setQuizChoiceId(Integer quizChoiceId) {
		this.quizChoiceId = quizChoiceId;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public Integer getQuizNum() {
		return quizNum;
	}
	public void setQuizNum(Integer quizNum) {
		this.quizNum = quizNum;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}