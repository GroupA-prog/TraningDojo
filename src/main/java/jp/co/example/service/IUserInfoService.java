package jp.co.example.service;

import java.util.List;

import jp.co.example.dto.entity.UserInfo;

public interface IUserInfoService {

	public List<UserInfo> selectAll();
	public UserInfo findByLoginId(String loginId);
	public int updateRole(String loginId, Integer role);
}
