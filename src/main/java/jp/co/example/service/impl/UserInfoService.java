package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.IUserInfoDao;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.IUserInfoService;

@Transactional
@Service
public class UserInfoService implements IUserInfoService {
	@Autowired
	private IUserInfoDao userInfoDao;

	@Override
	public List<UserInfo> selectAll() {
		List<UserInfo> list = userInfoDao.selectAll();
		return list;
	}

	@Override
	public UserInfo findByLoginId(String loginId) {
		List<UserInfo> list = userInfoDao.findByLoginId(loginId);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int updateRole(String loginId, Integer role) {
		return userInfoDao.updateRole(loginId, role);
	}

	@Override
	public UserInfo authentication(String loginId, String pass) {
		return userInfoDao.findByLoginIdAndPassword(loginId, pass);
	}

}
