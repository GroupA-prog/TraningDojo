package jp.co.example.dto;

public class LoginIdDTO {
	private String loginId;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Override
	public String toString() {
		return "LoginIdDTO [loginId=" + loginId + "]";
	}


}
