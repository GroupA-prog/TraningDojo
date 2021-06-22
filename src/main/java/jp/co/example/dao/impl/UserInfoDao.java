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
}
