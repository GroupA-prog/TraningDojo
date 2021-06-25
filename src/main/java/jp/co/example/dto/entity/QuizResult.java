package jp.co.example.dto.entity;

import java.sql.Timestamp;

public class QuizResult {
	private Integer quizId;
	private Integer correct;
	private Integer userAnswer;
	private Integer correctAnswer;
	//session用
	private Integer time;
	private Integer quizNum;
	private Integer nowSize;
	private String mode;
	private String categoryName;
	private Timestamp startTime;
	private Integer categoryId;
	private Integer modeId;
	private Integer userId;
	private Integer historyId;
	private Integer quizIndex;


	public Integer getQuizIndex() {
		return quizIndex;
	}
	public void setQuizIndex(Integer quizIndex) {
		this.quizIndex = quizIndex;
	}
	public Integer getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getModeId() {
		return modeId;
	}
	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getQuizNum() {
		return quizNum;
	}
	public void setQuizNum(Integer quizNum) {
		this.quizNum = quizNum;
	}
	public Integer getNowSize() {
		return nowSize;
	}
	public void setNowSize(Integer nowSize) {
		this.nowSize = nowSize;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
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
	public Integer getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(Integer userAnswer) {
		this.userAnswer = userAnswer;
	}
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
