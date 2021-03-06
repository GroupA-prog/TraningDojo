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
		List<Category> categoryAll = categoryService.selectAllDisplay();
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
		//???????????????????????????????????????????????????
		session.removeAttribute("quizListHarf");
		session.removeAttribute("quizList");
		session.removeAttribute("userAnswer");
		session.removeAttribute("quizStatus");
		return "home";
	}



	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String quizGet(@ModelAttribute("quiz")QuizForm form,Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}
		return "quiz";
	}

	@RequestMapping(value="/quiz",method=RequestMethod.POST)
	public String quizPost(@ModelAttribute("quizConfig")QuizForm form,RedirectAttributes redirectAttributes) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (loginUserInfo == null) {
			return "redirect:/login";
		}
		//?????????start?????????????????????
		QuizResult status = new QuizResult();
		status.setQuizIndex(0);
		long millis = System.currentTimeMillis();
		Timestamp start = new Timestamp(millis);
		status.setStartTime(start);
		//?????????????????????????????????
		status.setMode(quizService.selectMode(form.getMode()));
		status.setModeId(form.getMode());
		//??????????????????????????????????????????5???????????????????????????
		List<List<Quiz>> quizList = new ArrayList<List<Quiz>>();
		//???????????????
		if(form.getMode() == 1) {
			if(form.getQuizNum() == 0) {
				redirectAttributes.addFlashAttribute("studyError","????????????????????????");
				return "redirect:quizConfig";
			}
			status.setCategoryName(categoryService.findByCategoryId(form.getCategoryId()).get(0).getCategoryName());
			quizList = quizService.findByCategoryQuiz(form.getCategoryId(), form.getQuizNum());
			session.setAttribute("quizList", quizList);
			session.setAttribute("quizListHarf",quizList.get(status.getQuizIndex()));
			status.setQuizNum(form.getQuizNum());
		}else if(form.getMode() == 2){//????????????????????????
			status.setCategoryName(categoryService.findByCategoryId(form.getRankCategoryId()).get(0).getCategoryName());
			quizList = quizService.findByRankCategory(form.getRankCategoryId());
			try {
				List<Quiz>quiz = quizList.get(1);
				quiz.get(4);
			}catch (RuntimeException e) {
				redirectAttributes.addFlashAttribute("rankError","????????????????????????");
				return "redirect:quizConfig";
			}
			status.setTime(20);
			status.setQuizNum(10);
			session.setAttribute("quizList", quizList);
			session.setAttribute("quizListHarf",quizList.get(status.getQuizIndex()));

		}
		//???????????????????????????????????????????????????
		List<List<Integer>>userAnswer = quizService.answerList(status.getQuizNum());
		status.setNowSize((1 + status.getQuizIndex()) * 5);
		if(status.getQuizNum() < status.getNowSize()) {
			status.setNowSize(status.getQuizNum());
			redirectAttributes.addFlashAttribute("next",1);
		}
		session.setAttribute("quizStatus", status);
		session.setAttribute("userAnswer", userAnswer);
		return "redirect:quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="next",method=RequestMethod.POST)
	public String quizPostNext(@ModelAttribute("quiz")QuizForm form,Model model) {
		//????????????????????????????????????????????????
		QuizResult status = (QuizResult) session.getAttribute("quizStatus");
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("userAnswer");
		List<Integer> choiceList = new ArrayList<Integer>();
		quizService.choiceUpdate(choiceList,form.getChoiceId1(),form.getChoiceId2(),form.getChoiceId3(),form.getChoiceId4(),form.getChoiceId5());
		quizService.answerUpdate(answer,status.getQuizIndex(),choiceList);
		session.setAttribute("userAnswer", answer);
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		for(int i = 0; i < quizList.get(status.getQuizIndex()).size(); i++) {
			quizList.get(status.getQuizIndex()).get(i).setUserAnswer(answer.get(status.getQuizIndex()).get(i));
		}
		//??????5??????????????????????????????
		status.setQuizIndex(status.getQuizIndex()+1);
		session.setAttribute("quizListHarf",quizList.get(status.getQuizIndex()) );
		//??????????????????????????????
		try {
		form.setChoiceId1(answer.get(status.getQuizIndex()).get(0));
		form.setChoiceId2(answer.get(status.getQuizIndex()).get(1));
		form.setChoiceId3(answer.get(status.getQuizIndex()).get(2));
		form.setChoiceId4(answer.get(status.getQuizIndex()).get(3));
		form.setChoiceId5(answer.get(status.getQuizIndex()).get(4));
		}catch(RuntimeException e) {

		}
		//????????????????????????????????????
		if(status.getQuizIndex() == (quizList.size() - 1)) {
			model.addAttribute("nextDisplay",1);
		}
		model.addAttribute("returnDisplay",1);
		//??????????????????

		status.setNowSize((1 + status.getQuizIndex()) * 5);
		if(status.getQuizNum() < status.getNowSize()) {
			status.setNowSize(status.getQuizNum());
		}
		session.setAttribute("quizStatus",status);
		return "quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="return",method=RequestMethod.POST)
	public String quizPostReturn(@ModelAttribute("quiz")QuizForm form,Model model) {
		QuizResult status = (QuizResult) session.getAttribute("quizStatus");
		//????????????????????????????????????????????????
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("userAnswer");
		List<Integer> choiceList = new ArrayList<Integer>();
		quizService.choiceUpdate(choiceList,form.getChoiceId1(),form.getChoiceId2(),form.getChoiceId3(),form.getChoiceId4(),form.getChoiceId5());
		quizService.answerUpdate(answer,status.getQuizIndex(),choiceList);
		session.setAttribute("userAnswer", answer);
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		for(int i = 0; i < quizList.get(status.getQuizIndex()).size(); i++) {
			quizList.get(status.getQuizIndex()).get(i).setUserAnswer(answer.get(status.getQuizIndex()).get(i));
		}
		//??????5??????????????????????????????
		status.setQuizIndex(status.getQuizIndex() - 1);
		session.setAttribute("quizListHarf",quizList.get(status.getQuizIndex()) );
		form.setChoiceId1(answer.get(status.getQuizIndex()).get(0));
		form.setChoiceId2(answer.get(status.getQuizIndex()).get(1));
		form.setChoiceId3(answer.get(status.getQuizIndex()).get(2));
		form.setChoiceId4(answer.get(status.getQuizIndex()).get(3));
		form.setChoiceId5(answer.get(status.getQuizIndex()).get(4));
		//???????????????????????????
		if(status.getQuizIndex() != 0) {
			model.addAttribute("returnDisplay",1);
		}
		//??????????????????
		status.setNowSize((1 + status.getQuizIndex()) * 5);
		status.setQuizIndex(status.getQuizIndex());
		session.setAttribute("quizStatus", status);
		return "quiz";
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="finish",method=RequestMethod.POST)
	public String quizPostFinish(@ModelAttribute("quiz")QuizForm form,Model model) {
		QuizResult status = (QuizResult) session.getAttribute("quizStatus");
		//????????????????????????????????????????????????
		List<List<Integer>>answer = (List<List<Integer>>) session.getAttribute("userAnswer");
		List<Integer> choiceList = new ArrayList<Integer>();
		quizService.choiceUpdate(choiceList,form.getChoiceId1(),form.getChoiceId2(),form.getChoiceId3(),form.getChoiceId4(),form.getChoiceId5());
		quizService.answerUpdate(answer,status.getQuizIndex(),choiceList);
		session.setAttribute("userAnswer", answer);
		//???????????????
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		List<QuizResult> correctList = new ArrayList<QuizResult>();
		quizService.setQuiz(correctList,quizList,answer);
		//?????????????????????????????????ID?????????
		int categoryId = categoryService.findByCategoryName(status.getCategoryName()).get(0).getCategoryId();
		status.setCategoryId(categoryId);
		//session??????userId?????????
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUserInfo");
		status.setUserId(userInfo.getUserId());

		//???????????????
		int historyId = quizService.insertHistory(status);
		//?????????????????????
		quizService.insertHistoryDetail(correctList,historyId);
		session.setAttribute("userAnswer", correctList);

		//???????????????List??????
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
		//???????????????
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
		return "redirect:userHome";
	}
}