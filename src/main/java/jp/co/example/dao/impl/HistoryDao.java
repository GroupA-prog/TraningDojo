package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.IHistoryDao;
import jp.co.example.dto.entity.History;

@Repository
public class HistoryDao implements IHistoryDao {
	//logList.jsp用
	private static final String FIND_BY_LOGINID_CATEGORYID = "SELECT *, ROW_NUMBER() OVER(ORDER BY history_date) AS row_number FROM history WHERE user_id = :userId AND category_id = :categoryId";

	//logDetail.jsp用
	private static final String FIND_BY_COUNT_BY_HISTORYID = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY history_date) AS row_number FROM history WHERE user_id = 1 AND category_id = 1) AS rou_number_table WHERE history_id = :historyId";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<History> findByLoginIdAndCategoryId(Integer userId, Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = FIND_BY_LOGINID_CATEGORYID;

		param.addValue("userId", userId);
		param.addValue("categoryId", categoryId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<History>(History.class));
	}

	public List<History> findRowNumberByhistoryId(Integer historyId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = FIND_BY_COUNT_BY_HISTORYID;

		param.addValue("historyId", historyId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<History>(History.class));
	}

}
