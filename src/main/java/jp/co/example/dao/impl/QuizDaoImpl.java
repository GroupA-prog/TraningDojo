package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;

public class QuizDaoImpl implements QuizDao{

	private static final String SELECT_QUIZ = "SELECT * FROM (SELECT * FROM quiz WHERE category_id = :categoryId) AS quiz ORDER BY random() LIMIT :quizNum";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//
	public List<Quiz> findByCategoryQuiz(Integer categoryId,Integer quizNum){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		param.addValue("quizNum", quizNum);

		return jdbcTemplate.query(SELECT_QUIZ, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}
}
