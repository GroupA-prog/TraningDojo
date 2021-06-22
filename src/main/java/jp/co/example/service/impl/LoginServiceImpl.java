package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.example.dao.LoginDao;
import jp.co.example.dto.entity.Login;
import jp.co.example.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
    public Login authentication(String loginId, String password) {
        return loginDao.findByLoginIdAndPassword(loginId, password);
    }

	@Override
	public Login findByLoginId(String loginId) {
		return loginDao.findByLoginId(loginId);
	}

	@Override
	public Login findAll() {
		return (Login) loginDao.findAll();
	}

}
