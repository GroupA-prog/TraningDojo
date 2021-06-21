package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.QuizForm;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.service.QuizService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> branch 'main' of https://github.com/GroupA-prog/TraningDojo.git

@Controller
public class QuizTamayoseController{

	@Autowired
	private QuizService quizService;

	@Autowired
	private HttpSession session;


	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String quizGet(@ModelAttribute("quiz")QuizForm form,Model model) {
		if(form.getMode()==1) {
			List<Quiz> quizList = quizService.findByCategoryQuiz(form.getCategoryId(), form.getQuizNum());

			
		}

		return "quiz";
	}

	@RequestMapping(value="/quiz",params="next",method=RequestMethod.POST)
	public String quizPostNext() {
		return "quiz";
	}

	@RequestMapping(value="/quiz",params="return",method=RequestMethod.POST)
	public String quizPostReturn() {
		return "quiz";
	}


	@RequestMapping(value="/quiz",params="finish",method=RequestMethod.POST)
	public String quizPostFinish() {
		return "quiz";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet() {
		return "login";
	}
}