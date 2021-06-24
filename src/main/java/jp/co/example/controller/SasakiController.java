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
import jp.co.example.service.HomeService;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.QuizConfigService;

@Controller
public class SasakiController {

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private QuizConfigService quizConfigService;
	@Autowired
	private HomeService homeService;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/quizConfig", method = RequestMethod.GET)
	public String quizConfig(@ModelAttribute("quizConfig") QuizForm form, Model model) {
		List<Category> categoryAll = categoryService.selectAll();
		List<Category> categoryName = quizConfigService.categoryNameAll();
		session.setAttribute("categoryAll", categoryAll);
		session.setAttribute("categoryName", categoryName);

		return "quizConfig";

	}

	@RequestMapping(value="/userHome",method=RequestMethod.GET)
	public String userHome(@ModelAttribute("quizConfig") QuizForm form,Model model) {
		List<Category> parentCategory = homeService.parentCategoryAll();
		session.setAttribute("parentCategory",parentCategory);
		System.out.print(parentCategory);

		return "home";
	}


}
