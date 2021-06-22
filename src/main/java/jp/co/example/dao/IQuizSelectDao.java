package jp.co.example.dao;

public interface IQuizSelectDao {
	public int insertQuizSelect(Integer quizId, Integer choiceId, String choice);
	public int updateQuiz(Integer quizId, Integer choiceId, String choice);
}
