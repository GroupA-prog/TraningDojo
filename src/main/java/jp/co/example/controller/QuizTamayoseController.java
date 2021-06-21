package jp.co.example.controller;

@Controller
public class QuizController{

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

	@RequestMapping(value="/quiz"param="finish",method=RequestMethod.POST)
	public String quizPostFinish() {
		return "quiz";
	}

	@RequestMapping(value="/retired",method=RequestMethod.GET)
	public String retiredGet() {
		return "login";
	}
}