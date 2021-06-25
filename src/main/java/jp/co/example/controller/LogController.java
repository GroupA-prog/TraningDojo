package jp.co.example.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.LogForm;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.History;
import jp.co.example.dto.entity.HistoryDetailDisp;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.IHistoryDetailService;
import jp.co.example.service.IHistoryService;

@Controller
public class LogController {
	@Autowired
	ICategoryService ICService;

	@Autowired
	IHistoryService IHService;

	@Autowired
	IHistoryDetailService IHDService;

	@Autowired
	HttpSession session;

	//logCategory.jsp
	@RequestMapping(value = "/logCategory")
	public String logCategory(Model model) {
		//ユーザーがログインしているか確認
		//sessionにログイン情報が保存されているか確認
		/*to do:if文の条件式を変更する*/
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}

		//カテゴリ一覧を取得
		List<Category> categoryList = ICService.selectParentCategory();

		//取得したカテゴリ一覧をmodelに格納
		model.addAttribute("categoryList", categoryList);

		return "logCategory";

	}

	//logList.jsp
	@RequestMapping(value = "/logList", method = RequestMethod.GET)
	public String logList(@ModelAttribute("logList") LogForm form, Model model) {
		//ユーザーがログインしているか確認
		//sessionにログイン情報が保存されているか確認
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}

		//LogCategory.jspで選択したcategoryIdを受け取る
		Integer categoryId = form.getCategoryId();
		session.setAttribute("logSelectCategoryId", categoryId); //ユーザーが選択したcategoryIdをsessionに保存

		//表示のためにcategoryIdからカテゴリ名取得
		List<Category> categoryList = ICService.findByCategoryId(categoryId);
		model.addAttribute("category", categoryList.get(0));

		//表示のためにList<History>を取得
		List<History> historyList = IHService.findByLoginIdAndCategoryId(loginUserInfo.getUserId(),
				categoryId); /*to do:←1の部分はsessionに保存されているuserIdに変更する*/
		//取得した履歴一覧をmodelに格納
		model.addAttribute("history", historyList);

		List<Timestamp> updateTimeList = new ArrayList<>();

		for (int i = 0; i < historyList.size(); i++) {
			Timestamp updateTime = IHDService.findUpdateTimeByHistoryId(historyList.get(i).getHistoryId());

			System.out.println(i + "番目の更新時間：" + updateTime);

			updateTimeList.add(updateTime);
		}
		model.addAttribute("updateTimeList", updateTimeList);

		return "logList";
	}

	//logDetail.jsp
	@RequestMapping(value = "/logDetail", method = RequestMethod.GET)
	public String logDetai(@ModelAttribute("logDetail") LogForm form, Model model) {
		//logList.jspで選択した履歴IDを取得
		Integer selectHistoryId = form.getHistoryId();

		//カテゴリ名表示のためにcategoryIdからカテゴリ名を検索
		//1.sessionに保存されているユーザーが選択したcategoryIdを取得
		Integer logSelectCategoryId = (Integer) session.getAttribute("logSelectCategoryId");
		//2.検索を行う
		List<Category> categoryList = ICService.findByCategoryId(logSelectCategoryId);
		//3.modelに格納
		model.addAttribute("category", categoryList.get(0));

		//回数表示のためにList<History>を取得
		List<History> historyCount = IHService.findRowNumberByhistoryId(selectHistoryId);
		//取得した履歴一覧をmodelに格納
		model.addAttribute("historyCount", historyCount.get(0));

		//問題数の取得
		Integer quizNumber = IHDService.countByHistoryId(selectHistoryId);
		//表示のためにmodelに格納
		model.addAttribute("quizNumber", quizNumber);

		//履歴IDからクイズ、クイズ選択肢、履歴詳細を取得
		List<HistoryDetailDisp> dispQuiz = IHDService.findHistoryDetailDisp(selectHistoryId);

		//ページ内遷移のためにrowNumberをmodelに格納

		session.setAttribute("dispQuiz", dispQuiz);

		for (int i = 0; i < dispQuiz.size(); i++) {
			System.out.println(dispQuiz.get(i).getComment());
			if (dispQuiz.get(i).getComment() == null || dispQuiz.get(i).getComment().equals("")) {
				dispQuiz.get(i).setComment("コメントはまだありません。");
			}
		}

		for (int i = 0; i < dispQuiz.size(); i++) {
			if (dispQuiz.get(i).getCommentary() == null || dispQuiz.get(i).getCommentary().equals("")
					|| dispQuiz.get(i).getCommentary().equals("NULL")) {
				dispQuiz.get(i).setCommentary("解説はまだありません。");
			}
		}

		//		//ユーザーがといたクイズIDを取得
		//		List<Integer> selectQuizId = IHDService.findQuizIdByHistoryId(selectHistoryId);

		return "logDetail";
	}

	//	//logDetail.jsp→logList.jsp
	//	@RequestMapping(valur="logList", params="back")
	//	public String logDetailBack(@ModelAttribute("logDetail") LogForm form, Model model) {
	//
	//	}
	@RequestMapping(value = "/logList", method = RequestMethod.POST)
	public String updateComment(@ModelAttribute("commentUpdate") LogForm form, Model model) {
		//画面遷移のためにsessionに保存されているcategoryIdを取得
		Integer selectLogCategory = (Integer) session.getAttribute("logSelectCategoryId");

		Timestamp newUpdateTime = new Timestamp(System.currentTimeMillis());

		for (int i = 0; i < form.getComment().size(); i++) {
			if (form.getComment().get(i) != null && !form.getComment().get(i).equals("")) {
				IHDService.updateComment(form.getComment().get(i), form.getHistoryDetailId().get(i), newUpdateTime);
			}
		}

		return "redirect:/logList?categoryId=" + selectLogCategory;
	}
}
