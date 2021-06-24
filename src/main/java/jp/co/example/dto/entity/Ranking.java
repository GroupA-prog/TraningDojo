package jp.co.example.dto.entity;

public class Ranking {
	private Integer rank;
	private Integer userId;
	private String userName;
	private Double score;

	public Ranking() {
	}

	public Ranking(Integer rank, Integer userId, String userName, double score) {
		this.rank = rank;
		this.userId = userId;
		this.userName =  userName;
		this.score = score;
	}

	public Ranking(Integer rank, double score) {
		this.rank = rank;
		this.score = score;
	}

	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}

}
