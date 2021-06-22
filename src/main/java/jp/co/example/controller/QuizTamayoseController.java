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

import jp.co.example.controller.form.QuizForm;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.QuizService;

@Controller
public class QuizTamayoseController{
	public static int quizIndex = 0;
	@Autowired
	private QuizService quizService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private HttpSession session;


	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String quizGet(@ModelAttribute("quiz")QuizForm form,Model model) {
		return "quiz";
	}

	@RequestMapping(value="/quiz",method=RequestMethod.POST)
	public String quizPost(@ModelAttribute("quiz")QuizForm form,Model model) {
		//クイズstart時刻取得・保持
		long millis = System.currentTimeMillis();
		Timestamp start = new Timestamp(millis);
		session.setAttribute("startTime", start);
		//戻るボタン表示判断
		model.addAttribute("returnDisplay",0);
		//モード：カテゴリ名保存
		String categoryName = categoryService.findByCategoryId(form.getCategoryId()).get(0).getCategoryName();
		session.setAttribute("categoryName", categoryName);
		session.setAttribute("mode", quizService.selectMode(form.getMode()));

		List<List<Quiz>> quizList = new ArrayList<List<Quiz>>();
		//モード分岐、制限時間・問題数（5問分け済み）を保存
		if(form.getMode() == 1) {
			quizList = quizService.findByCategoryQuiz(form.getCategoryId(), form.getQuizNum());
			session.setAttribute("quizList", quizList);
			model.addAttribute("quiz",quizList.get(quizIndex));
		}else if(form.getMode() == 2){
			quizList = quizService.findByRankCategory(form.getCategoryId());
			session.setAttribute("time", form.getQuizNum()*2);
			session.setAttribute("quizList", quizList);
			model.addAttribute("quiz",quizList.get(quizIndex));
		}
		//問題数・解答セッションを作成、保存
		int nowSize = (1 + quizIndex) * 5;
		int maxSize = quizService.ListSize(quizList);
		List<List<Integer>>answerList = quizService.answerList(maxSize);
		model.addAttribute("nowSize", nowSize);
		model.addAttribute("maxSize", maxSize);
		session.setAttribute("answerList", answerList);
		return "redirect:/quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="next",method=RequestMethod.POST)
	public String quizPostNext(@ModelAttribute("quiz")QuizForm form,Model model) {
		//ユーザーの解答をセッションへ更新
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("answerList");
		quizService.answerUpdate(answer,quizIndex,form.getChoiceId());
		session.setAttribute("answerList", answer);
		//次の5問へセッションを更新
		quizIndex++;
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		model.addAttribute("quiz",quizList.get(quizIndex) );
		//次へボタン表示判断
		if(quizIndex == (quizList.size() - 1)) {
			model.addAttribute("nextDisplay",0);
		}
		//問題数の更新
		int nowSize = (1 + quizIndex) * 5;
		model.addAttribute("nowSize", nowSize);
		return "quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="return",method=RequestMethod.POST)
	public String quizPostReturn(@ModelAttribute("quiz")QuizForm form,Model model) {
		//ユーザーの解答をセッションへ更新
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("answerList");
		quizService.answerUpdate(answer,quizIndex,form.getChoiceId());
		session.setAttribute("answerList", answer);
		//前の5問へセッションを更新
		quizIndex--;
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		model.addAttribute("quiz",quizList.get(quizIndex) );
		//戻るボタン表示判断
		if(quizIndex == 0) {
			model.addAttribute("returnDisplay",0);
		}
		//問題数の更新
		int nowSize = (1 + quizIndex) * 5;
		model.addAttribute("nowSize", nowSize);
		return "quiz";
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="finish",method=RequestMethod.POST)
	public String quizPostFinish(@ModelAttribute("quiz")QuizForm form,Model model) {
		//ユーザーの解答をセッションへ更新
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("answerList");
		quizService.answerUpdate(answer,quizIndex,form.getChoiceId());
		session.setAttribute("answerList", answer);
		//モードをIDに変換
		String mode = (String) session.getAttribute("mode");
		int modeId = quizService.selectModeId(mode);
		//カテゴリ名からIDを取得
		String categoryName = (String) session.getAttribute("categoryName");
		int categoryId = categoryService.findByCategoryName(categoryName).get(0).getCategoryId();
		//ユーザーId、日付を取得

		Timestamp startTime = (Timestamp) session.getAttribute("startTime");
		//答え合わせ
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		List<Integer>correct = quizService.scoring(quizList,answer);


		//モード判断
		if(modeId == 1) {
			return "answerDatail";
		}
		return "rankingView";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet() {
		//ログイン情報以外のセッションを破棄
		session.removeAttribute("mode");
		session.removeAttribute("time");
		session.removeAttribute("quizList");
		session.removeAttribute("categoryName");
		session.removeAttribute("answerList");
		session.removeAttribute("startTime");
		return "quizConfig";
	}
}