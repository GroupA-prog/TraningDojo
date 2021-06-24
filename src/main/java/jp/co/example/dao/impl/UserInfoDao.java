package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.IUserInfoDao;
import jp.co.example.dto.entity.UserInfo;

@Repository
public class UserInfoDao implements IUserInfoDao {
	private static final String SELECT_ALL = "SELECT user_id, login_id, role FROM user_info WHERE login_id <> 'administrator' ORDER BY login_id ASC;";
	private static final String FIND_BY_LOGINID = "SELECT * FROM user_info WHERE login_id = :login_id;";
	private static final String UPDATE_USER_ROLE = "UPDATE user_info SET role = :role WHERE login_id = :login_id;";
	private static final String UPDATE_USER_NAME_AND_PASS = "UPDATE user_info SET password = :password, user_name = :user_name WHERE user_id = :user_id;";
	private static final String FIND_BY_LOGINID_AND_PASS = "SELECT * FROM user_info WHERE login_id = :login_id AND password = :password;";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<UserInfo> selectAll() {
		return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
	}

	@Override
	public List<UserInfo> findByLoginId(String loginId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login_id", loginId);

		return jdbcTemplate.query(FIND_BY_LOGINID, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
	}

	@Override
	public int updateRole(String loginId, Integer role) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login_id", loginId);
		param.addValue("role", role);

		return jdbcTemplate.update(UPDATE_USER_ROLE, param);
	}

	@Override
	public int  updateUserInfo(String password, String userName, Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("password", password);
		param.addValue("user_name", userName);
		param.addValue("user_id", userId);

		return jdbcTemplate.update(UPDATE_USER_NAME_AND_PASS, param);
	}

	@Override
	public UserInfo findByUserANDPass(String loginId, String pass) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login_id", loginId);
		param.addValue("password", pass);

		List<UserInfo> list =  jdbcTemplate.query(FIND_BY_LOGINID_AND_PASS, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return list.isEmpty() ? null : list.get(0);
	}
}
