package jp.co.example.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.HomeDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Home;
import jp.co.example.dto.entity.UserInfo;

@Repository
public class HomeDaoImpl implements HomeDao {

	private static final String parent_category = "SELECT category_id,category_name FROM category WHERE parent_category_id IS NULL;";
	private static final String answer_late_list = "SELECT category_id, category_name, correct_total, question_total, round(correct_total / question_total * 100, 0) AS ratio FROM (SELECT history_id, category_id, category_name, correct, question_num, sum(correct) OVER ( PARTITION BY category_id ORDER BY history_id DESC ROWS BETWEEN 0 PRECEDING AND 4 FOLLOWING) AS correct_total, sum(question_num) OVER ( PARTITION BY category_id ORDER BY history_id DESC ROWS BETWEEN 0 PRECEDING AND 4 FOLLOWING) AS question_total, ROW_NUMBER() OVER ( PARTITION BY category_id ORDER BY history_id DESC) as level FROM ( SELECT h.history_id AS history_id, h.category_id AS category_id, max(c.category_name) AS category_name, sum(correct) AS correct, count(*) AS question_num FROM history h JOIN history_detail hd ON hd.history_id = h.history_id JOIN category c ON c.category_id = h.category_id WHERE h.user_id = :user_id AND h.mode = 1 GROUP BY h.history_id, h.category_id UNION SELECT max(h.history_id) AS history_id ,c.category_id AS category_id ,max(c.category_name) AS category_name, 0 AS correct, count(*) AS question_num FROM history h RIGHT OUTER JOIN category c ON c.category_id = h.category_id AND h.user_id = :user_id WHERE  h.history_id IS NULL GROUP BY c.category_id ) AS list ) AS view WHERE level = 1 AND category_id IN ( WITH RECURSIVE category_list(category_id) AS ( SELECT category_id FROM category WHERE category_id = :select_category_id UNION ALL SELECT c.category_id FROM category c JOIN category_list cl ON cl.category_id = c.parent_category_id ) select * from category_list );";
	private static final String categoryName = "SELECT category_name \r\n"
			+ "FROM category\r\n"
			+ "WHERE category_id IN (\r\n"
			+ "SELECT category_id\r\n"
			+ "FROM category\r\n"
			+ "WHERE parent_category_id = :categoryId);";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private HttpSession session;

	public List<Category> parentCategoryAll(){
		return jdbcTemplate.query(parent_category, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public List<Home> answerLateList(Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		UserInfo user = (UserInfo) session.getAttribute("loginUserInfo");
		param.addValue("user_id",user.getUserId());
		param.addValue("select_category_id",categoryId);

		return jdbcTemplate.query(answer_late_list,param, new BeanPropertyRowMapper<Home>(Home.class));
	}

	public List<Home> fullCategory(Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);

		return jdbcTemplate.query(categoryName,param, new BeanPropertyRowMapper<Home>(Home.class));
	}


}
