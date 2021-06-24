package jp.co.example.service;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.dto.entity.HistoryDetail;
import jp.co.example.dto.entity.HistoryDetailDisp;

public interface IHistoryDetailService {
	//logDetail.jsp>>問題数取得
	public Integer countByHistoryId(Integer historyId);

	//	//logDetail.jsp>>ユーザーが解いたクイズID取得
	//	public List<Integer> findQuizIdByHistoryId(Integer historyId);

	public List<HistoryDetail> findAllByHistoryId(Integer historyId);

	//logDetai.jsp>>クイズ問題文、選択肢、解説、コメント表示？
	public List<HistoryDetailDisp> findHistoryDetailDisp(Integer historyId);

	//logDetail.jsp>>comment更新
	public void updateComment(String comment, Integer historyDetailId, Timestamp updateTime);

	//logList.jsp>>update_time表示
	public Timestamp findUpdateTimeByHistoryId(Integer historyId);
}
