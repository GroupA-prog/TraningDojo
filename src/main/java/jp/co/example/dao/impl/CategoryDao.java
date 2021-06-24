package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ICategoryDao;
import jp.co.example.dto.entity.Category;

@Repository
public class CategoryDao implements ICategoryDao {
	private static final String SELECT_All = "WITH RECURSIVE category_list(category_id, category_name) AS ( SELECT category_id, CAST(category_name AS TEXT) FROM category WHERE parent_category_id IS NULL UNION ALL SELECT c.category_id, concat(cl.category_name,'->', c.category_name) FROM category c JOIN category_list cl ON cl.category_id = c.parent_category_id ) SELECT * FROM category_list ORDER BY category_name;";
	private static final String INSERT = "INSERT INTO category (category_name, display, parent_category_id) VALUES (:category_name, :display, CASE WHEN :parent_category_id = -1 THEN NULL ELSE :parent_category_id END);";
	private static final String UPDATE = "UPDATE category SET category_name = :category_name, display = :display, parent_category_id = CASE WHEN :parent_category_id = -1 THEN NULL ELSE :parent_category_id END WHERE category_id = :category_id;";
	private static final String FIND_BY_CATEGORY_NAME = "SELECT * FROM category WHERE category_name = :category_name;";
	private static final String FIND_BY_CATEGORY_ID = "SELECT * FROM category WHERE category_id = :category_id;";
	private static final String FIND_BY_PARENT_CATEGORY = "SELECT * FROM category WHERE parent_category_id IS NULL";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<Category> selectAll() {
		return jdbcTemplate.query(SELECT_All, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public int insert(String categoryName, Integer display, Integer parentCategoryId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_name", categoryName);
		param.addValue("display", display);
		param.addValue("parent_category_id", parentCategoryId == null ? -1 : parentCategoryId);
		return jdbcTemplate.update(INSERT, param);
	}


	public int update(Integer categoryId, String categoryName, Integer display, Integer parentCategoryId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_id", categoryId);
		param.addValue("category_name", categoryName);
		param.addValue("display", display);
		param.addValue("parent_category_id", parentCategoryId);

		return jdbcTemplate.update(UPDATE, param);
	}

	public List<Category> findByCategoryName(String categoryName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_name", categoryName);
		return jdbcTemplate.query(FIND_BY_CATEGORY_NAME, param, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public List<Category> findByCategoryId(Integer categoryId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_id", categoryId);
		return jdbcTemplate.query(FIND_BY_CATEGORY_ID, param, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public List<Category> findByParentCategory(){
		return jdbcTemplate.query(FIND_BY_PARENT_CATEGORY,new BeanPropertyRowMapper<Category>(Category.class));
	}
}
