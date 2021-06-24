package jp.co.example.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.IHistoryDetailDao;
import jp.co.example.dto.entity.HistoryDetail;
import jp.co.example.dto.entity.HistoryDetailDisp;
import jp.co.example.service.IHistoryDetailService;

@Service
public class HistoryDetailService implements IHistoryDetailService {
	@Autowired
	IHistoryDetailDao IHDDao;

	//logDetail.jsp>>問題数取得
	public Integer countByHistoryId(Integer historyId) {
		return IHDDao.countByHistoryId(historyId);
	}

	//	//logDetail.jsp>>ユーザーが解いたクイズID取得
	//	public List<Integer> findQuizIdByHistoryId(Integer historyId) {
	//		return IHDDao.findQuizIdByHistoryId(historyId);
	//	}

	//logDetai.jsp>>クイズ問題文、選択肢、解説、コメント表示？
	public List<HistoryDetailDisp> findHistoryDetailDisp(Integer historyId) {
		return IHDDao.findHistoryDetailDisp(historyId);
	}

	//logDetail.jsp>>comment更新
	public void updateComment(String comment, Integer historyDetailId, Timestamp updateTime) {
		IHDDao.updateComment(comment, historyDetailId, updateTime);
	}

	//logList.jsp>>update_time表示
	public Timestamp findUpdateTimeByHistoryId(Integer historyId) {
		return IHDDao.findUpdateTimeByHistoryId(historyId);
	}

	public List<HistoryDetail> findAllByHistoryId(Integer historyId) {
		return IHDDao.findAllByHistoryId(historyId);
	}
}
