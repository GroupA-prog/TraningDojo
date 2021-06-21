package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;

public class QuizDaoImpl implements QuizDao{

	private static final String SELECT_QUIZ = "SELECT * FROM (SELECT * FROM quiz WHERE category_id = :categoryId ORDER BY random() LIMIT :quizNum) AS quiz JOIN quiz_select qs ON quiz.quiz_id = qs.quiz_id";
	private static final String SELECT_RANK_CATEGORY = "SELECT * FROM (SELECT * FROM quiz WHERE category_id = :categoryId) AS quiz ORDER BY random() LIMIT 10";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//学習モード
	public List<Quiz> findByCategoryQuiz(Integer categoryId,Integer quizNum){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		param.addValue("quizNum", quizNum);

		return jdbcTemplate.query(SELECT_QUIZ, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}
	//ランキングモード（カテゴリあり）
	public List<Quiz> findByRankCategory(Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);

		return jdbcTemplate.query(SELECT_RANK_CATEGORY, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));

	}
}
