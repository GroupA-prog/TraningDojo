package jp.co.example.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.QuizForm;
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class QuizTamayoseController{

	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String quizGet(@ModelAttribute("quiz")QuizForm form,Model model) {
		if(form.getMode()==2) {
			List<quiz> quizList =

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

	@RequestMapping(value="/quiz",param="finish",method=RequestMethod.POST)

	public String quizPostFinish() {
		return "quiz";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet() {
		return "login";
	}
}