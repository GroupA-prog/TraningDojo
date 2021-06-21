package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.example.dao.QuizDao;

public class QuizDaoImpl implements QuizDao{

	private static final String SELECT_QUIZ = "SELECT * FROM quiz q JOIN quiz_select s ON q.quiz_id = s.quiz_id WHERE category_id = :categoryId";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//

}
