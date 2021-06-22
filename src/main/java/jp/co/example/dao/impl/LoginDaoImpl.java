package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.LoginDao;
import jp.co.example.dto.entity.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

	private static final String SELECT_ALL = "select * from user_info";

	private static final String SELECT_BY_LOGIN_ID_AND_PASS = "select * from user_info where login_id = :loginId and password = :password";

	private static final String SELECT_BY_LOGIN_ID = "select * from user_info where login_id = :loginId";

	private static final String INSERT = "insert into user_info (login_id, password, user_name, role) values (:loginId, password, userName, Role)";

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Login> findAll() {
		List<Login> list = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Login>(Login.class));

        return list;
	}

	@Override
	public Login findByLoginIdAndPassword(String loginId, String password) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", loginId);
        param.addValue("password", password);

        List<Login> list = jdbcTemplate.query(SELECT_BY_LOGIN_ID_AND_PASS, param,
                new BeanPropertyRowMapper<Login>(Login.class));

        return list.isEmpty() ? null : list.get(0);
    }

	@Override
	public Login findByLoginId(String loginId) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", loginId);

        List<Login> list = jdbcTemplate.query(SELECT_BY_LOGIN_ID, param,
                new BeanPropertyRowMapper<Login>(Login.class));

        return list.isEmpty() ? null : list.get(0);
    }

	@Override
    public void insert(Login user) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", user.getLoginId());
        param.addValue("userName", user.getUserName());
        param.addValue("password", user.getPassword());
        param.addValue("role", 2);

        jdbcTemplate.update(INSERT, param);
    }

}
