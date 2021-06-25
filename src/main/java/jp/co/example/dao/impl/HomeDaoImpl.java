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
	private static final String answer_late_list = "SELECT user_id,category_id,category_name,correct_total,question_total, round(correct_total / question_total * 100, 0) AS ratio FROM (SELECT history_id,user_id,category_id,category_name,correct,question_num,sum(correct) OVER ( PARTITION BY user_id, category_id ORDER BY history_id DESC ROWS BETWEEN 0 PRECEDING AND 4 FOLLOWING) AS correct_total,sum(question_num) OVER ( PARTITION BY user_id, category_id ORDER BY history_id DESC ROWS BETWEEN 0 PRECEDING AND 4 FOLLOWING) AS question_total,ROW_NUMBER() OVER ( PARTITION BY user_id, category_id ORDER BY history_id DESC) as level FROM (SELECT h.history_id AS history_id,h.user_id AS user_id,h.category_id AS category_id,max(c.category_name) AS category_name,count(*) AS question_num,sum(hd.correct) AS correct FROM history h JOIN history_detail hd ON hd.history_id = h.history_id JOIN category c ON c.category_id = h.category_id WHERE h.mode = 1 AND h.user_id = :user_id GROUP BY h.history_id, h.user_id, h.category_id) AS list) AS view WHERE level = 1 AND category_id IN (WITH RECURSIVE category_list(category_id) AS (SELECT category_id FROM category WHERE category_id = :select_category_id UNION ALL SELECT c.category_id FROM category c JOIN category_list cl ON cl.category_id = c.parent_category_id) select * from category_list)";

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

		return jdbcTemplate.query(answer_late_list, new BeanPropertyRowMapper<Home>(Home.class));
	}


}
