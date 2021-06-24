package jp.co.example.dao;

import java.util.List;

import jp.co.example.dto.entity.UserInfo;

public interface IUserInfoDao {

	public List<UserInfo> selectAll();
	public List<UserInfo> findByLoginId (String loginId);
	public int updateRole(String loginId, Integer role);
	public int  updateUserInfo(String password, String userName, Integer userId);
	public UserInfo findByUserANDPass(String loginId, String pass);

}
