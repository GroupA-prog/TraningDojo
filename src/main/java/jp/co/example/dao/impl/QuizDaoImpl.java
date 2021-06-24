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

	private static final String SELECT_BY_STUDY_QUIZ = "WITH RECURSIVE category_list (category_id, category_name) AS (SELECT category_id, category_name FROM category WHERE category_id = :category_id UNION ALL SELECT c.category_id, c.category_name FROM category c INNER JOIN category_list cl ON c.parent_category_id = cl.category_id) SELECT max(q.quiz_id) AS quiz_id ,max(q.quiz_title) AS quiz_title,max(q.quiz_statment) AS quiz_statment,max(q.correct_answer) AS correct_answer,max(q.display) AS display,max(q.commentary) AS commentary,max(cl.category_name) AS category_name,max( CASE WHEN qs.quiz_choice_id = 1 THEN qs.choice ELSE NULL END) AS choice1,max( CASE WHEN qs.quiz_choice_id = 2 THEN qs.choice ELSE NULL END) AS choice2,max( CASE WHEN qs.quiz_choice_id = 3 THEN qs.choice ELSE NULL END) AS choice3,max( CASE WHEN qs.quiz_choice_id = 4 THEN qs.choice ELSE NULL END) AS choice4 FROM quiz q JOIN category_list cl ON q.category_id = cl.category_id JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE display = 1 GROUP BY q.quiz_id ORDER BY RANDOM() LIMIT :quiz_count";
	private static final String SELECT_BY_RANK_QUIZ = "WITH RECURSIVE category_list (category_id, category_name) AS (SELECT category_id, category_name FROM category WHERE category_id = :category_id UNION ALL SELECT c.category_id, c.category_name FROM category c INNER JOIN category_list cl ON c.parent_category_id = cl.category_id) SELECT max(q.quiz_id) AS quiz_id ,max(q.quiz_title) AS quiz_title,max(q.quiz_statment) AS quiz_statment,max(q.correct_answer) AS correct_answer,max(q.display) AS display,max(q.commentary) AS commentary,max(cl.category_name) AS category_name,max( CASE WHEN qs.quiz_choice_id = 1 THEN qs.choice ELSE NULL END) AS choice1,max( CASE WHEN qs.quiz_choice_id = 2 THEN qs.choice ELSE NULL END) AS choice2,max( CASE WHEN qs.quiz_choice_id = 3 THEN qs.choice ELSE NULL END) AS choice3,max( CASE WHEN qs.quiz_choice_id = 4 THEN qs.choice ELSE NULL END) AS choice4 FROM quiz q JOIN category_list cl ON q.category_id = cl.category_id JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE display = 1 GROUP BY q.quiz_id ORDER BY RANDOM() LIMIT 10";
	private static final String INSERT_QUIZ = "INSERT INTO quiz (category_id, quiz_title, quiz_statment, correct_answer, commentary, display) VALUES (:category_id, :quiz_title, :quiz_statment, :correct_answer, :commentary, :display);";
	private static final String SELECT_BY_QUIZ_TITLE = "SELECT * FROM quiz WHERE category_id = :category_id AND quiz_title = :quiz_title;";
	private static final String SELECT_BY_CATEGORYID = "SELECT * FROM quiz WHERE category_id = :category_id ORDER BY quiz_id;";
	private static final String SELECT_BY_QUIZID = "SELECT * FROM quiz q INNER JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE q.quiz_id = :quiz_id ORDER BY qs.quiz_choice_id;";
	private static final String UPDATE = "UPDATE quiz SET category_id = :category_id, quiz_title = :quiz_title, quiz_statment = :quiz_statment, correct_answer = :correct_answer, commentary = :commentary, display = :display WHERE quiz_id = :quiz_id;";
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
	public List<Quiz> findByQuizTitle(Integer categoryId, String quizTitle) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_title", quizTitle);
		param.addValue("category_id", categoryId);
		return jdbcTemplate.query(SELECT_BY_QUIZ_TITLE, param, new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}

	@Override
	public List<QuizJoinQuizSelect> findByQuizId(Integer quizId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_id", quizId);
		return jdbcTemplate.query(SELECT_BY_QUIZID, param, new BeanPropertyRowMapper<QuizJoinQuizSelect>(QuizJoinQuizSelect.class));
	}

	public int updateQuiz(Integer quizId, Integer categoryId, String quizTitle, String quizStatment, Integer correctAnswer, String commentary, Integer display) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_id", quizId);
		param.addValue("category_id", categoryId);
		param.addValue("quiz_title", quizTitle);
		param.addValue("quiz_statment", quizStatment);
		param.addValue("correct_answer", correctAnswer);
		param.addValue("commentary", commentary);
		param.addValue("display", display);
		return jdbcTemplate.update(UPDATE, param);
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
		param.addValue("category_id", categoryId);
		param.addValue("quiz_count", quizNum);

		return jdbcTemplate.query(SELECT_BY_STUDY_QUIZ, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}
	//ランキングモード
	@Override
	public List<Quiz> findByRankCategory(Integer categoryId){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("category_id", categoryId);

		return jdbcTemplate.query(SELECT_BY_RANK_QUIZ, param,
				new BeanPropertyRowMapper<Quiz>(Quiz.class));

	}
}
