package jp.co.example.controller;

@Controller
public class QuizController{

	@RequestMapping(value="/quizConfig",method=RequestMethod.GET)
	public String quizConfig() {
		return "quizConfig";
	}
}