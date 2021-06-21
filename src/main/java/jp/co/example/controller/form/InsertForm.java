package jp.co.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InsertForm {
	@NotBlank
	@NotNull
	private String newLoginId;
	@NotBlank
	@NotNull
	private String newPassword;
	@NotBlank
	@NotNull
	private String newUserName;
	@NotBlank
	@NotNull
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
