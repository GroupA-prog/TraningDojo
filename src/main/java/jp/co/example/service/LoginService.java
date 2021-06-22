package jp.co.example.service;

import jp.co.example.dto.entity.Login;

public interface LoginService {
	public Login authentication(String loginId, String password);

    public Login findByLoginId(String loginId);

    public Login findAll();
}
