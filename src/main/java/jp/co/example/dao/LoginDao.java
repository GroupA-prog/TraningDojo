package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.Login;

public interface LoginDao {
	public List<Login> findAll();
	public Login findByLoginIdAndPassword(String loginId, String password);
	public Login findByLoginId (String loginId);
}
