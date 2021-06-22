package jp.co.example.dto.entity;

public class QuizJoinQuizSelect {
	private Integer quizId;
	private Integer categoryId;
	private String quizTitle;
	private String quizStatment;
	private Integer correctAnswer;
	private String commentary;
	private Integer display;
	private Integer quizChoiceId;
	private String choice;
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
	public String getQuizStatment() {
		return quizStatment;
	}
	public void setQuizStatment(String quizStatement) {
		this.quizStatment = quizStatement;
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
	@Override
	public String toString() {
		return "QuizJoinQuizSelect [quizId=" + quizId + ", categoryId=" + categoryId + ", quizTitle=" + quizTitle
				+ ", quizStatement=" + quizStatment + ", correctAnswer=" + correctAnswer + ", commentary=" + commentary
				+ ", display=" + display + ", quizChoiceId=" + quizChoiceId + ", choice=" + choice + "]";
	}



}
