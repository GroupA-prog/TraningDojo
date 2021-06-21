package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.QuizForm;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.QuizConfigService;

@Controller
public class SasakiController {

	@Autowired
	private QuizConfigService quizConfigService;
	@Autowired
	private HttpSession session;

	@RequestMapping(value="/quizConfig",method=RequestMethod.GET)
	public String quizConfig(@ModelAttribute("")QuizForm form,Model model) {
		List<Category> categoryName = quizConfigService.categoryNameAll();
		model.addAttribute("categoryName",categoryName);

		return "quizConfig";
	}

	@RequestMapping(value="/quizConfig",method=RequestMethod.POST)
	public String quiz() {
		return "quiz";
	}

}
