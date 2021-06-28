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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.example.controller.form.QuizForm;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.QuizResult;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.HomeService;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.QuizConfigService;
import jp.co.example.service.QuizService;

@Controller
public class QuizController{
	public static int quizIndex = 0;
	@Autowired
	private QuizService quizService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private HttpSession session;

	@Autowired
	private QuizConfigService quizConfigService;
	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/quizConfig", method = RequestMethod.GET)
	public String quizConfigGet(@ModelAttribute("quizConfig") QuizForm form, Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}
		List<Category> categoryAll = categoryService.selectAll();
		List<Category> categoryName = quizConfigService.categoryNameAll();
		session.setAttribute("categoryAll", categoryAll);
		session.setAttribute("categoryName", categoryName);

		return "quizConfig";

	}

	@RequestMapping(value="/userHome",method=RequestMethod.GET)
	public String userHomeGet(@ModelAttribute("quizConfig") QuizForm form,Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}
		List<Category> parentCategory = homeService.parentCategoryAll();
		session.setAttribute("parentCategory",parentCategory);

		return "home";
	}



	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String quizGet(@ModelAttribute("quiz")QuizForm form,Model model) {
		return "quiz";
	}

	@RequestMapping(value="/quiz",method=RequestMethod.POST)
	public String quizPost(@ModelAttribute("quizConfig")QuizForm form,RedirectAttributes redirectAttributes) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}
		quizIndex = 0;
		//クイズstart時刻取得・保持
		QuizResult status = new QuizResult();
		long millis = System.currentTimeMillis();
		Timestamp start = new Timestamp(millis);
		status.setStartTime(start);
		//モード：カテゴリ名保存
		status.setMode(quizService.selectMode(form.getMode()));
		status.setModeId(form.getMode());
		List<List<Quiz>> quizList = new ArrayList<List<Quiz>>();

		//モード分岐、制限時間・問題（5問分け済み）を保存
		if(form.getMode() == 1) {
			if(form.getQuizNum() == 0) {
				redirectAttributes.addFlashAttribute("studyError","問題数は必須です");
				return "redirect:quizConfig";
			}
			status.setCategoryName(categoryService.findByCategoryId(form.getCategoryId()).get(0).getCategoryName());
			quizList = quizService.findByCategoryQuiz(form.getCategoryId(), form.getQuizNum());
			session.setAttribute("quizList", quizList);
			session.setAttribute("quizListHarf",quizList.get(quizIndex));
			status.setQuizNum(form.getQuizNum());
		}else if(form.getMode() == 2){
			status.setCategoryName(categoryService.findByCategoryId(form.getRankCategoryId()).get(0).getCategoryName());
			quizList = quizService.findByRankCategory(form.getRankCategoryId());
			try {
				List<Quiz>quiz = quizList.get(1);
				quiz.get(4);
			}catch (RuntimeException e) {
				redirectAttributes.addFlashAttribute("rankError","問題がありません");
				return "redirect:quizConfig";
			}
			status.setTime(20);

			status.setQuizNum(10);
			session.setAttribute("quizList", quizList);
			session.setAttribute("quizListHarf",quizList.get(quizIndex));

		}
		//問題数・解答セッションを作成、保存
		List<List<Integer>>userAnswer = quizService.answerList(status.getQuizNum());
		status.setNowSize((1 + quizIndex) * 5);
		if(status.getQuizNum() < status.getNowSize()) {
			status.setNowSize(status.getQuizNum());
		}
		status.setQuizIndex(quizIndex);
		session.setAttribute("quizStatus", status);
		session.setAttribute("userAnswer", userAnswer);
		return "redirect:quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="next",method=RequestMethod.POST)
	public String quizPostNext(@ModelAttribute("quiz")QuizForm form,Model model) {
		//ユーザーの解答をセッションへ更新
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("userAnswer");
		List<Integer> choiceList = new ArrayList<Integer>();
		quizService.choiceUpdate(choiceList,form.getChoiceId1(),form.getChoiceId2(),form.getChoiceId3(),form.getChoiceId4(),form.getChoiceId5());
		quizService.answerUpdate(answer,quizIndex,choiceList);
		session.setAttribute("userAnswer", answer);
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		for(int i = 0; i < quizList.get(quizIndex).size(); i++) {
			quizList.get(quizIndex).get(i).setUserAnswer(answer.get(quizIndex).get(i));
		}
		//次の5問へセッションを更新
		quizIndex++;
		session.setAttribute("quizListHarf",quizList.get(quizIndex) );
		try {
		form.setChoiceId1(answer.get(quizIndex).get(0));
		form.setChoiceId2(answer.get(quizIndex).get(1));
		form.setChoiceId3(answer.get(quizIndex).get(2));
		form.setChoiceId4(answer.get(quizIndex).get(3));
		form.setChoiceId5(answer.get(quizIndex).get(4));
		}catch(RuntimeException e) {

		}
		//次へ・前へボタン表示判断
		if(quizIndex == (quizList.size() - 1)) {
			model.addAttribute("nextDisplay",1);
		}
		model.addAttribute("returnDisplay",1);
		//問題数の更新
		QuizResult status = (QuizResult) session.getAttribute("quizStatus");
		status.setNowSize((1 + quizIndex) * 5);
		if(status.getQuizNum() < status.getNowSize()) {
			status.setNowSize(status.getQuizNum());
		}
		status.setQuizIndex(quizIndex);
		session.setAttribute("quizStatus",status);
		return "quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="return",method=RequestMethod.POST)
	public String quizPostReturn(@ModelAttribute("quiz")QuizForm form,Model model) {
		//ユーザーの解答をセッションへ更新
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("userAnswer");
		List<Integer> choiceList = new ArrayList<Integer>();
		quizService.choiceUpdate(choiceList,form.getChoiceId1(),form.getChoiceId2(),form.getChoiceId3(),form.getChoiceId4(),form.getChoiceId5());
		quizService.answerUpdate(answer,quizIndex,choiceList);
		session.setAttribute("userAnswer", answer);
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		for(int i = 0; i < quizList.get(quizIndex).size(); i++) {
			quizList.get(quizIndex).get(i).setUserAnswer(answer.get(quizIndex).get(i));
		}
		//前の5問へセッションを更新
		quizIndex--;
		session.setAttribute("quizListHarf",quizList.get(quizIndex) );
		form.setChoiceId1(answer.get(quizIndex).get(0));
		form.setChoiceId2(answer.get(quizIndex).get(1));
		form.setChoiceId3(answer.get(quizIndex).get(2));
		form.setChoiceId4(answer.get(quizIndex).get(3));
		form.setChoiceId5(answer.get(quizIndex).get(4));
		//戻るボタン表示判断
		if(quizIndex != 0) {
			model.addAttribute("returnDisplay",1);
		}
		//問題数の更新
		QuizResult status = (QuizResult) session.getAttribute("quizStatus");
		status.setNowSize((1 + quizIndex) * 5);
		status.setQuizIndex(quizIndex);
		session.setAttribute("quizStatus", status);
		return "quiz";
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="finish",method=RequestMethod.POST)
	public String quizPostFinish(@ModelAttribute("quiz")QuizForm form,Model model) {

		//ユーザーの解答をセッションへ更新
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("userAnswer");
		List<Integer> choiceList = new ArrayList<Integer>();
		quizService.choiceUpdate(choiceList,form.getChoiceId1(),form.getChoiceId2(),form.getChoiceId3(),form.getChoiceId4(),form.getChoiceId5());
		quizService.answerUpdate(answer,quizIndex,choiceList);
		session.setAttribute("userAnswer", answer);
		session.setAttribute("userAnswer", answer);
		//答え合わせ
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		List<QuizResult> correctList = new ArrayList<QuizResult>();
		quizService.setQuiz(correctList,quizList,answer);
		QuizResult status = (QuizResult) session.getAttribute("quizStatus");
		//カテゴリ名からカテゴリIDを取得
		int categoryId = categoryService.findByCategoryName(status.getCategoryName()).get(0).getCategoryId();
		status.setCategoryId(categoryId);
		//sessionからuserIdを取得
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUserInfo");
		status.setUserId(userInfo.getUserId());

		//履歴に登録
		int historyId = quizService.insertHistory(status);
		//履歴詳細に登録
		quizService.insertHistoryDetail(correctList,historyId);
		session.setAttribute("userAnswer", correctList);

		//解答詳細用List準備
		List<Quiz>quizAll = new ArrayList<Quiz>();
		for(int i = 0;i < quizList.size();i++) {
			quizAll.addAll(quizList.get(i));
		}
		for(int i = 0; i < quizAll.size(); i++) {
			quizAll.get(i).setUserAnswer(correctList.get(i).getUserAnswer());
		}
		for(Quiz q:quizAll) {
			if(q.getCommentary().equals("NULL")) {
				q.setCommentary("");
			}
		}
		session.setAttribute("quizStatus", status);
		session.setAttribute("quizList", quizAll);
		//モード判断
		if(status.getModeId() == 1) {
			return "redirect:/answerDetail";
		}

		return "redirect:/rankingView?categoryId=" + categoryId;
	}

	@RequestMapping(value="/answerDetail")
	public String answerDetailGet(Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}
		return "answerDetail";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet(@ModelAttribute("quizConfig")QuizForm form,Model model) {
		//ログイン情報以外のセッションを破棄
		session.removeAttribute("quizListHarf");
		session.removeAttribute("quizList");
		session.removeAttribute("userAnswer");
		session.removeAttribute("quizStatus");
		return "home";
	}


}