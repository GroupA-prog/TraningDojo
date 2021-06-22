package jp.co.example.controller;

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
		model.addAttribute("returnDisplay",0);
		String categoryName = categoryService.findByCategoryId(form.getCategoryId()).get(0).getCategoryName();
		session.setAttribute("categoryName", categoryName);
		session.setAttribute("mode", quizService.selectMode(form.getMode()));
		List<List<Quiz>> quizList = new ArrayList<List<Quiz>>();

		if(form.getMode() == 1) {
			quizList = quizService.findByCategoryQuiz(form.getCategoryId(), form.getQuizNum());
			session.setAttribute("time", form.getQuizNum()*2);
			session.setAttribute("quizList", quizList.get(quizIndex));
		}else if(form.getMode() == 2){
			quizList = quizService.findByRankCategory(form.getCategoryId());
			session.setAttribute("time", 20);
			session.setAttribute("quizList", quizList.get(quizIndex));
		}

		int maxSize = quizService.ListSize(quizList);
		List<List<Integer>>answerList = quizService.answerList(maxSize);
		session.setAttribute("answerList", answerList);
		session.setAttribute("maxSize", maxSize);
		return "quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="next",method=RequestMethod.POST)
	public String quizPostNext(@ModelAttribute("quiz")QuizForm form,Model model) {
		quizIndex++;
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		if(quizIndex == (quizList.size() - 1)) {
			model.addAttribute("nextDisplay",0);
		}
		session.setAttribute("quizList",quizList.get(quizIndex) );
		return "quiz";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/quiz",params="return",method=RequestMethod.POST)
	public String quizPostReturn(@ModelAttribute("quiz")QuizForm form,Model model) {
		quizIndex--;
		List<List<Quiz>>quizList = (List<List<Quiz>>) session.getAttribute("quizList");
		if(quizIndex == 0) {
			model.addAttribute("returnDisplay",0);
		}
		session.setAttribute("quizList",quizList.get(quizIndex) );
		return "quiz";
	}



	@RequestMapping(value="/quiz",params="finish",method=RequestMethod.POST)
	public String quizPostFinish() {
		String mode = (String) session.getAttribute("mode");
		if(mode.equals("学習")) {

			return "answerDatail";
		}
		return "rankingView";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet() {
		session.removeAttribute("mode");
		session.removeAttribute("time");
		session.removeAttribute("quizList");
		session.removeAttribute("categoryName");
		session.removeAttribute("answerList");
		return "quizConfig";
	}


}