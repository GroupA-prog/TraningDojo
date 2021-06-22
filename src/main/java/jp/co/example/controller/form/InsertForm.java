package jp.co.example.controller.form;

import javax.validation.constraints.NotBlank;

public class InsertForm {
	@NotBlank(message="ログインIDは必須です")
	private String newLoginId;
	@NotBlank(message="パスワードは必須です")
	private String newPassword;
	@NotBlank(message="ユーザーネームは必須です")
	private String newUserName;
	private String newPasswordRe;

	public String getNewLoginId() {
		return newLoginId;
	}

	public void setNewLoginId(String newLoginId) {
		this.newLoginId = newLoginId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	public String getNewPasswordRe() {
		return newPasswordRe;
	}

	public void setNewPasswordRe(String newPasswordRe) {
		this.newPasswordRe = newPasswordRe;
	}
}
