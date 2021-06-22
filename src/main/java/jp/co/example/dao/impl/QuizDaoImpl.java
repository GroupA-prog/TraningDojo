package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.QuizJoinQuizSelect;

@Repository
public class QuizDaoImpl implements QuizDao{

	private static final String SELECT_QUIZ = "SELECT * FROM (SELECT * FROM quiz WHERE display = 1 AND category_id = :categoryId ORDER BY random() LIMIT :quizNum) AS quiz JOIN quiz_select qs ON quiz.quiz_id = qs.quiz_id";
	private static final String SELECT_RANK_CATEGORY = "SELECT * FROM (SELECT * FROM quiz WHERE display = 1 category_id = :categoryId ORDER BY random() LIMIT 10) AS quiz JOIN quiz_select qs ON quiz.quiz_id = qs.quiz_id";
	private static final String INSERT_QUIZ = "INSERT INTO quiz (category_id, quiz_title, quiz_statment, correct_answer, commentary, display) VALUES (:category_id, :quiz_title, :quiz_statment, :correct_answer, :commentary, :display);";
	private static final String SELECT_BY_QUIZ_TITLE = "SELECT * FROM quiz WHERE quiz_title = :quiz_title;";
	private static final String SELECT_BY_CATEGORYID = "SELECT * FROM quiz WHERE category_id = :category_id ORDER BY quiz_id;";
	private static final String SELECT_BY_QUIZID = "SELECT * FROM quiz q INNER JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE q.quiz_id = :quiz_id ORDER BY qs.quiz_choice_id;";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
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

	@Override
	public List<Quiz> findByQuizTitle(String quizTitle) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_title", quizTitle);
		return jdbcTemplate.query(SELECT_BY_QUIZ_TITLE, param, new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}

	@Override
	public List<QuizJoinQuizSelect> findByQuizId(Integer quizId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_id", quizId);
		return jdbcTemplate.query(SELECT_BY_QUIZID, param, new BeanPropertyRowMapper<QuizJoinQuizSelect>(QuizJoinQuizSelect.class));
	}

	//カテゴリごとのクイズを調べる
	@Override
	public List<Quiz> findByCategoryId(Integer categoryId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_id", categoryId);
		return jdbcTemplate.query(SELECT_BY_CATEGORYID, param, new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}

	//学習モード
	@Override
	public List<Quiz> findByCategoryQuiz(Integer categoryId,Integer quizNum){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);
		param.addValue("quizNum", quizNum);

		return jdbcTemplate.query(SELECT_QUIZ, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}
	//ランキングモード（カテゴリあり）
	@Override
	public List<Quiz> findByRankCategory(Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("categoryId", categoryId);

		return jdbcTemplate.query(SELECT_RANK_CATEGORY, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));

	}
}
