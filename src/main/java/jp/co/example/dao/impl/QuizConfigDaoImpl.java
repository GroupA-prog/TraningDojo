package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.QuizConfigDao;
import jp.co.example.dto.entity.Category;

@Repository
public class QuizConfigDaoImpl implements QuizConfigDao {

	private static final String rankCategoryName = "select category_id,category_name from category where parent_category_id is NULL;";
	private static final String categoryNum = "select count(*) from quiz where category_id = :categoryId;";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Category> categoryNameAll() {

		return jdbcTemplate.query(rankCategoryName, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public int categoryNum(Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		int result = jdbcTemplate.queryForObject(categoryNum, param, Integer.class);

		return result;
	}

}
