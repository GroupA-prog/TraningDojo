package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.example.dao.QuizConfigDao;
import jp.co.example.dto.entity.Category;

public class QuizConfigDaoImpl implements QuizConfigDao {

	private static final String CategoryAll = "select category_name from category";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Category> categoryNameAll() {

		return jdbcTemplate.query(CategoryAll, new BeanPropertyRowMapper<Category>(Category.class));
	}

}