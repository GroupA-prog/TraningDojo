package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.QuizDao;

@Repository
public class QuizDaoImpl implements QuizDao{

	private static final String SELECT_QUIZ = "SELECT * FROM quiz q JOIN quiz_select s ON q.quiz_id = s.quiz_id WHERE category_id = :categoryId";
	private static final String INSERT_QUIZ = "INSERT INTO quiz (category_id, quiz_title, quiz_statment, correct_answer, commentary, display) VALUES (:category_id, :quiz_title, :quiz_statment, :correct_answer, :commentary, :display);";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public int insertQuiz(Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_id", categoryId);
		param.addValue("quiz_title", quizTitle);
		param.addValue("quiz_statment", quizStatment);
		param.addValue("correct_answer", correctAnswer);
		param.addValue("commentary", commentary);
		param.addValue("display", display);

		return jdbcTemplate.update(INSERT_QUIZ, param);
	}

}
