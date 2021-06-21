package jp.co.example.dto.entity;

public class Quiz {
	private Integer quizId;
	private Integer categoryId;
	private Integer quizChoiceId;
	private Integer correctAnswer;
	private Integer userAnswer;
	private String quizStatement;
	private String choice;
	private String commentary;
	private String quizTitle;
	private Integer display;


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


}
