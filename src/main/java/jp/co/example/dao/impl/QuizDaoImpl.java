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
import jp.co.example.dto.entity.QuizResult;

@Repository
public class QuizDaoImpl implements QuizDao{

	private static final String SELECT_BY_STUDY_QUIZ = "WITH RECURSIVE category_list (category_id, category_name) AS (SELECT category_id, category_name FROM category WHERE category_id = :category_id UNION ALL SELECT c.category_id, c.category_name FROM category c INNER JOIN category_list cl ON c.parent_category_id = cl.category_id) SELECT max(q.quiz_id) AS quiz_id ,max(q.quiz_title) AS quiz_title,max(q.quiz_statment) AS quiz_statment,max(q.correct_answer) AS correct_answer,max(q.display) AS display,max(q.commentary) AS commentary,max(cl.category_name) AS category_name,max( CASE WHEN qs.quiz_choice_id = 1 THEN qs.choice ELSE NULL END) AS choice1,max( CASE WHEN qs.quiz_choice_id = 2 THEN qs.choice ELSE NULL END) AS choice2,max( CASE WHEN qs.quiz_choice_id = 3 THEN qs.choice ELSE NULL END) AS choice3,max( CASE WHEN qs.quiz_choice_id = 4 THEN qs.choice ELSE NULL END) AS choice4 FROM quiz q JOIN category_list cl ON q.category_id = cl.category_id JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE display = 1 GROUP BY q.quiz_id ORDER BY RANDOM() LIMIT :quiz_count";
	private static final String SELECT_BY_RANK_QUIZ = "WITH RECURSIVE category_list (category_id, category_name) AS (SELECT category_id, category_name FROM category WHERE category_id = :category_id UNION ALL SELECT c.category_id, c.category_name FROM category c INNER JOIN category_list cl ON c.parent_category_id = cl.category_id) SELECT max(q.quiz_id) AS quiz_id ,max(q.quiz_title) AS quiz_title,max(q.quiz_statment) AS quiz_statment,max(q.correct_answer) AS correct_answer,max(q.display) AS display,max(q.commentary) AS commentary,max(cl.category_name) AS category_name,max( CASE WHEN qs.quiz_choice_id = 1 THEN qs.choice ELSE NULL END) AS choice1,max( CASE WHEN qs.quiz_choice_id = 2 THEN qs.choice ELSE NULL END) AS choice2,max( CASE WHEN qs.quiz_choice_id = 3 THEN qs.choice ELSE NULL END) AS choice3,max( CASE WHEN qs.quiz_choice_id = 4 THEN qs.choice ELSE NULL END) AS choice4 FROM quiz q JOIN category_list cl ON q.category_id = cl.category_id JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE display = 1 GROUP BY q.quiz_id ORDER BY RANDOM() LIMIT 10";
	private static final String INSERT_QUIZ = "INSERT INTO quiz (category_id, quiz_title, quiz_statment, correct_answer, commentary, display) VALUES (:category_id, :quiz_title, :quiz_statment, :correct_answer, :commentary, :display);";
	private static final String SELECT_BY_QUIZ_TITLE = "SELECT * FROM quiz WHERE category_id = :category_id AND quiz_title = :quiz_title;";
	private static final String SELECT_BY_CATEGORYID = "SELECT * FROM quiz WHERE category_id = :category_id ORDER BY quiz_id;";
	private static final String SELECT_BY_QUIZID = "SELECT * FROM quiz q INNER JOIN quiz_select qs ON q.quiz_id = qs.quiz_id WHERE q.quiz_id = :quiz_id ORDER BY qs.quiz_choice_id;";
	private static final String UPDATE = "UPDATE quiz SET category_id = :category_id, quiz_title = :quiz_title, quiz_statment = :quiz_statment, correct_answer = :correct_answer, commentary = :commentary, display = :display WHERE quiz_id = :quiz_id;";
	private static final String INSERT_HISTORY = "INSERT INTO history (history_date,user_id,mode,category_id) VALUES (:history_date,:user_id,:mode,:category_id);";
	private static final String SELECT_BY_HISTORY_ID = "SELECT history_id FROM history WHERE history_date = :history_date AND user_id = :user_id;";
	private static final String INSERT_HISTORY_DETAIL = "INSERT INTO history_detail (history_id,quiz_id,correct,user_answer) VALUES";
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

	//履歴登録・履歴Id取得
	@Override
	public int insertHistory(QuizResult quizResult) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("history_date", quizResult.getStartTime());
		param.addValue("user_id", quizResult.getUserId());
		param.addValue("mode", quizResult.getModeId());
		param.addValue("category_id", quizResult.getCategoryId());

		jdbcTemplate.update(INSERT_HISTORY, param);

		List<QuizResult>resultList = jdbcTemplate.query(SELECT_BY_HISTORY_ID,param,
				new BeanPropertyRowMapper<QuizResult>(QuizResult.class));
		QuizResult result = resultList.isEmpty() ? null : resultList.get(0);
		return result.getHistoryId();
	}

	//履歴詳細登録
	@Override
	public void insertHistoryDetail(List<QuizResult>quizResult,Integer historyId) {
		String sql = INSERT_HISTORY_DETAIL;
		MapSqlParameterSource param = new MapSqlParameterSource();
		for(int i = 0; i < quizResult.size();i++) {
			if(quizResult.size()-1 == i) {
				sql += "(:history_id"+i+",:quiz_id"+i+",:correct"+i+",:user_answer"+i+");";
			}else {
				sql += "(:history_id"+i+",:quiz_id"+i+",:correct"+i+",:user_answer"+i+"),";
			}
			param.addValue("history_id"+i+"", historyId);
			param.addValue("quiz_id"+i+"", quizResult.get(i).getQuizId());
			param.addValue("correct"+i+"", quizResult.get(i).getCorrect());
			param.addValue("user_answer"+i+"", quizResult.get(i).getUserAnswer());
		}
		jdbcTemplate.update(sql, param);
	}


}
