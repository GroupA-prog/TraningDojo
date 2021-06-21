package jp.co.example.controller.form;

public class AdminForm {
	//クイズ作成
	private Integer quizCategoryId;
	private String createQuizTitle;
	private String createProblemStatement;
	private String createChoice1;
	private String createChoice2;
	private String createChoice3;
	private String createChoice4;
	private Integer createAnswer;
	private String createCommentary;
	//クイズ編集
	private Integer editQuizCategoryId;
	private String editQuizTitle;
	private String editProblemStatement;
	private String editChoice1;
	private String editChoice2;
	private String editChoice3;
	private String editChoice4;
	private Integer editAnswer;
	private Integer quizDisplay;
	private String editCommentary;
	//カテゴリ作成
	private Integer categoryParentCategoryId;
	private String categoryName;
	//カテゴリ編集
	private Integer editCategoryId;
	private Integer editCategoryParentCategoryId;
	private String editCategoryName;
	private Integer categoryDisplay;
	//ユーザー情報
	private String loginId;
	private Integer role;
	public Integer getQuizCategoryId() {
		return quizCategoryId;
	}
	public void setQuizCategoryId(Integer quizCategoryId) {
		this.quizCategoryId = quizCategoryId;
	}
	public String getCreateQuizTitle() {
		return createQuizTitle;
	}
	public void setCreateQuizTitle(String createQuizTitle) {
		this.createQuizTitle = createQuizTitle;
	}
	public String getCreateProblemStatement() {
		return createProblemStatement;
	}
	public void setCreateProblemStatement(String createProblemStatement) {
		this.createProblemStatement = createProblemStatement;
	}
	public String getCreateChoice1() {
		return createChoice1;
	}
	public void setCreateChoice1(String createChoice1) {
		this.createChoice1 = createChoice1;
	}
	public String getCreateChoice2() {
		return createChoice2;
	}
	public void setCreateChoice2(String createChoice2) {
		this.createChoice2 = createChoice2;
	}
	public String getCreateChoice3() {
		return createChoice3;
	}
	public void setCreateChoice3(String createChoice3) {
		this.createChoice3 = createChoice3;
	}
	public String getCreateChoice4() {
		return createChoice4;
	}
	public void setCreateChoice4(String createChoice4) {
		this.createChoice4 = createChoice4;
	}
	public Integer getCreateAnswer() {
		return createAnswer;
	}
	public void setCreateAnswer(Integer createAnswer) {
		this.createAnswer = createAnswer;
	}
	public Integer getEditQuizCategoryId() {
		return editQuizCategoryId;
	}
	public void setEditQuizCategoryId(Integer editQuizCategoryId) {
		this.editQuizCategoryId = editQuizCategoryId;
	}
	public String getEditQuizTitle() {
		return editQuizTitle;
	}
	public void setEditQuizTitle(String editQuizTitle) {
		this.editQuizTitle = editQuizTitle;
	}
	public String getEditProblemStatement() {
		return editProblemStatement;
	}
	public void setEditProblemStatement(String editProblemStatement) {
		this.editProblemStatement = editProblemStatement;
	}
	public String getEditChoice1() {
		return editChoice1;
	}
	public void setEditChoice1(String editChoice1) {
		this.editChoice1 = editChoice1;
	}
	public String getEditChoice2() {
		return editChoice2;
	}
	public void setEditChoice2(String editChoice2) {
		this.editChoice2 = editChoice2;
	}
	public String getEditChoice3() {
		return editChoice3;
	}
	public void setEditChoice3(String editChoice3) {
		this.editChoice3 = editChoice3;
	}
	public String getEditChoice4() {
		return editChoice4;
	}
	public void setEditChoice4(String editChoice4) {
		this.editChoice4 = editChoice4;
	}
	public Integer getEditAnswer() {
		return editAnswer;
	}
	public void setEditAnswer(Integer editAnswer) {
		this.editAnswer = editAnswer;
	}
	public Integer getCategoryParentCategoryId() {
		return categoryParentCategoryId;
	}
	public void setCategoryParentCategoryId(Integer categoryParentCategoryId) {
		this.categoryParentCategoryId = categoryParentCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getEditCategoryParentCategoryId() {
		return editCategoryParentCategoryId;
	}
	public void setEditCategoryParentCategoryId(Integer editCategoryParentCategoryId) {
		this.editCategoryParentCategoryId = editCategoryParentCategoryId;
	}
	public String getEditCategoryName() {
		return editCategoryName;
	}
	public void setEditCategoryName(String editCategoryName) {
		this.editCategoryName = editCategoryName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getEditCommentary() {
		return editCommentary;
	}
	public void setEditCommentary(String editCommentary) {
		this.editCommentary = editCommentary;
	}
	public String getCreateCommentary() {
		return createCommentary;
	}
	public void setCreateCommentary(String createCommentary) {
		this.createCommentary = createCommentary;
	}

	public Integer getEditCategoryId() {
		return editCategoryId;
	}
	public void setEditCategoryId(Integer editCategoryId) {
		this.editCategoryId = editCategoryId;
	}
	public Integer getQuizDisplay() {
		return quizDisplay;
	}
	public void setQuizDisplay(Integer quizDisplay) {
		this.quizDisplay = quizDisplay;
	}
	public Integer getCategoryDisplay() {
		return categoryDisplay;
	}
	public void setCategoryDisplay(Integer categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}
	@Override
	public String toString() {
		return "AdminForm [quizCategoryId=" + quizCategoryId + ", createQuizTitle=" + createQuizTitle
				+ ", createProblemStatement=" + createProblemStatement + ", createChoice1=" + createChoice1
				+ ", createChoice2=" + createChoice2 + ", createChoice3=" + createChoice3 + ", createChoice4="
				+ createChoice4 + ", createAnswer=" + createAnswer + ", createCommentary=" + createCommentary
				+ ", editQuizCategoryId=" + editQuizCategoryId + ", editQuizTitle=" + editQuizTitle
				+ ", editProblemStatement=" + editProblemStatement + ", editChoice1=" + editChoice1 + ", editChoice2="
				+ editChoice2 + ", editChoice3=" + editChoice3 + ", editChoice4=" + editChoice4 + ", editAnswer="
				+ editAnswer + ", quizDisplay=" + quizDisplay + ", editCommentary=" + editCommentary
				+ ", categoryParentCategoryId=" + categoryParentCategoryId + ", categoryName=" + categoryName
				+ ", editCategoryId=" + editCategoryId + ", editCategoryParentCategoryId="
				+ editCategoryParentCategoryId + ", editCategoryName=" + editCategoryName + ", categoryDisplay="
				+ categoryDisplay + ", loginId=" + loginId + ", role=" + role + "]";
	}




}
