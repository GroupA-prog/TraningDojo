package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.UserInfo;

public interface IUserInfoDao {

	public List<UserInfo> selectAll();
	public List<UserInfo> findByUserId(Integer userId);
	public int updateRole(String loginId, Integer role);

}
