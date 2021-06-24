package jp.co.example.dto.entity;

public class RankingCategory {
	private Integer categoryId;
	private String categoryName;
	private Integer display;
	private Integer parentCategoryId;

	public RankingCategory() {

	}

	public RankingCategory(Integer categoryId, String categoryName, Integer display, Integer parentCategoryId) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.display = display;
		this.parentCategoryId = parentCategoryId;
	}


	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

}
