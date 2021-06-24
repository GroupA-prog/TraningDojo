package jp.co.example.dto.entity;

import java.sql.Timestamp;

public class HistoryDetail {
	private Integer historyDetailId;
	private Integer historyId;
	private Integer quizId;
	private Integer correct;
	private String comment;
	private Integer userAnswer;
	private Timestamp updateTime;

	public HistoryDetail() {
	}

	public HistoryDetail(Integer historyDetailId, Integer historyId, Integer quizId, Integer correct, String comment, Integer userAnswer) {
		this.historyDetailId = historyDetailId;
		this.historyId = historyId;
		this.quizId = quizId;
		this.correct = correct;
		this.comment = comment;
		this.userAnswer = userAnswer;
	}


	public Integer getHistoryDetailId() {
		return historyDetailId;
	}
	public void setHistoryDetailId(Integer historyDetailId) {
		this.historyDetailId = historyDetailId;
	}
	public Integer getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(Integer userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
