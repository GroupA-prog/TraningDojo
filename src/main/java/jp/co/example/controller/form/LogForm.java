package jp.co.example.controller.form;

import java.util.List;

public class LogForm {
	private Integer categoryId;	//カテゴリ選択
	private Integer historyId;		//履歴選択
	private List<String> comment;		//コメント入力
	private List<Integer> historyDetailId;
	private Integer updateTime;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	public List<String> getComment() {
		return comment;
	}

	public void setComment(List<String> comment) {
		this.comment = comment;
	}

	public List<Integer> getHistoryDetailId() {
		return historyDetailId;
	}

	public void setHistoryDetailId(List<Integer> historyDetailId) {
		this.historyDetailId = historyDetailId;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}




}
