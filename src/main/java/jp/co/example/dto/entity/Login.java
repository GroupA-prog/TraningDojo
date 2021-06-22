package jp.co.example.dto.entity;

public class Login {
	private Integer userId;
	private String loginId;
	private String password;
	private String userName;
	private Integer role;

	public Login(String newLoginId, String newPassword, String newUserName) {
		loginId = newLoginId;
		password = newPassword;
		userName = newUserName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
