package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuizTamayoseController{

	@RequestMapping(value="/quiz",method=RequestMethod.GET)
	public String quizGet() {
		return "quiz";
	}

	@RequestMapping(value="/quiz",param="next",method=RequestMethod.POST)
	public String quizPostNext() {
		return "quiz";
	}

	@RequestMapping(value="/quiz",param="return",method=RequestMethod.POST)
	public String quizPostReturn() {
		return "quiz";
	}

	@RequestMapping(value="/quiz",param="finish",method=RequestMethod.POST)
	public String quizPostFinish() {
		return "quiz";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet() {
		return "login";
	}
}