package jp.co.example.controller.form;

import javax.validation.constraints.NotEmpty;

public class EditUserForm {
	@NotEmpty(message="ユーザーIDを入力してください")
	private String userLoginId;
	@NotEmpty(message="※新しいパスワードを入力してください")
	private String newPassword;
	@NotEmpty(message="※確認用パスワードを入力してください")
	private String reNewPassword;
	@NotEmpty(message="※ユーザー名を入力してください")
	private String newUserName;


	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	@Override
	public String toString() {
		return "EditUserForm [userLoginId=" + userLoginId + ", newPassword=" + newPassword + ", reNewPassword="
				+ reNewPassword + ", newUserName=" + newUserName + "]";
	}

}
