package jp.co.example.dto.entity;

public class QuizSelect {
	private Integer quizId;
	private Integer quizChoiceId;
	private String choice;
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
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
		return "QuizSelect [quizId=" + quizId + ", quizChoiceId=" + quizChoiceId + ", choice=" + choice + "]";
	}


}
