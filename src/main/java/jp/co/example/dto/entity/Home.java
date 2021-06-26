package jp.co.example.dto.entity;

public class Home {

	private Integer categoryId;
	private Integer ratio;
	private String categoryName;


	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getRatio() {
		return ratio;
	}

	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Home [categoryId=" + categoryId + ", ratio=" + ratio + ", categoryName=" + categoryName + "]";
	}





}
