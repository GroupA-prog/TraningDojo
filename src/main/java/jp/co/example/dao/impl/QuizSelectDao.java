package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.IQuizSelectDao;

@Repository
public class QuizSelectDao implements IQuizSelectDao {
	private static final String INSERT = "INSERT INTO quiz_select (quiz_id, quiz_choice_id, choice) VALUES (:quiz_id, :quiz_choice_id, :choice)";
	private static final String UPDATE = "UPDATE quiz_select SET  quiz_choice_id = :quiz_choice_id, choice = :choice WHERE quiz_id = :quiz_id AND quiz_choice_id = :quiz_choice_id;";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertQuizSelect(Integer quizId, Integer choiceId, String choice) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_id", quizId);
		param.addValue("quiz_choice_id", choiceId);
		param.addValue("choice", choice);
		return jdbcTemplate.update(INSERT, param);
	}

	@Override
	public int updateQuiz(Integer quizId, Integer choiceId, String choice) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quiz_id", quizId);
		param.addValue("quiz_choice_id", choiceId);
		param.addValue("choice", choice);

		return jdbcTemplate.update(UPDATE, param);
	}

}
