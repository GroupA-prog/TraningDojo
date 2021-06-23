package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.HomeDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Home;

@Repository
public class HomeDaoImpl implements HomeDao {

	private static final String parent_category = "SELECT category_id,category_name FROM category WHERE parent_category_id IS NULL;";
	private static final String answer_late_list = "";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Category> parentCategoryAll(){
		return jdbcTemplate.query(parent_category, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public List<Home> answerLateList(Integer categoryId){
		return jdbcTemplate.query(answer_late_list, new BeanPropertyRowMapper<Home>(Home.class));
	}

}
