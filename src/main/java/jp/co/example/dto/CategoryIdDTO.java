package jp.co.example.dto;

public class CategoryIdDTO {
	private Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "CategoryIdDTO [CategoryId=" + categoryId + "]";
	}



}
