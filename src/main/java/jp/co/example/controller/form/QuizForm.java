package jp.co.example.controller.form;

public class QuizForm{

	private Integer quizId;
	private Integer categoryId;
	private String quizTitle;
	private String quizStatement;
	private Integer correctAnswer;
	private String commentary;
	private Integer display;
	private Integer choiceId1;
	private Integer choiceId2;
	private Integer choiceId3;
	private Integer choiceId4;
	private Integer choiceId5;
	private String choice;
	private Integer mode;
	private String categoryName;
	private Integer quizNum;


	public Integer getChoiceId1() {
		return choiceId1;
	}
	public void setChoiceId1(Integer choiceId1) {
		this.choiceId1 = choiceId1;
	}
	public Integer getChoiceId2() {
		return choiceId2;
	}
	public void setChoiceId2(Integer choiceId2) {
		this.choiceId2 = choiceId2;
	}
	public Integer getChoiceId3() {
		return choiceId3;
	}
	public void setChoiceId3(Integer choiceId3) {
		this.choiceId3 = choiceId3;
	}
	public Integer getChoiceId4() {
		return choiceId4;
	}
	public void setChoiceId4(Integer choiceId4) {
		this.choiceId4 = choiceId4;
	}
	public Integer getChoiceId5() {
		return choiceId5;
	}
	public void setChoiceId5(Integer choiceId5) {
		this.choiceId5 = choiceId5;
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