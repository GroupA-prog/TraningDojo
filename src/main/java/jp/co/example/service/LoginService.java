package jp.co.example.service;

import jp.co.example.dto.entity.Login;
import jp.co.example.dto.entity.UserInfo;

public interface LoginService {
	public UserInfo authentication(String loginId, String password);

    public Login findByLoginId(String loginId);

    public Login findAll();

    public void insert(Login user);

    public boolean existsUserByLoginId(String loginId);
}
