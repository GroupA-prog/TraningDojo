package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.AdminForm;

@Controller
public class AdminController {

	@RequestMapping(value="/admin")
	public String adminGet(@ModelAttribute("admin") AdminForm form, Model model) {
		/*ログインユーザーの情報が歩かないかの判断*/
		return "admin";
	}

	@RequestMapping(value="/admin", params="quizCreate", method=RequestMethod.POST)
	public String adminPostQuizCreate(@ModelAttribute("admin") AdminForm form, Model model) {
		System.out.println("quizCreate");
		System.out.println(form);
		return "admin";
	}

	@RequestMapping(value="/admin", params="quizEdit", method=RequestMethod.POST)
	public String adminPostQuizEdit(@ModelAttribute("admin") AdminForm form, Model model) {
		System.out.println("quizEdit");
		System.out.println(form);
		return "admin";
	}

	@RequestMapping(value="/admin", params="categoryCreate", method=RequestMethod.POST)
	public String adminPostCategoryCreate(@ModelAttribute("admin") AdminForm form, Model model) {
		System.out.println("categoryCreate");
		System.out.println(form);
		return "admin";
	}

	@RequestMapping(value="/admin", params="categoryEdit", method=RequestMethod.POST)
	public String adminPostCategoryEdit(@ModelAttribute("admin") AdminForm form, Model model) {
		System.out.println("categoryEdit");
		System.out.println(form);
		return "admin";
	}

	@RequestMapping(value="/admin", params="userEdit", method=RequestMethod.POST)
	public String adminPostUserEdit(@ModelAttribute("admin") AdminForm form, Model model) {
		System.out.println("userEdit");
		System.out.println(form);
		return "admin";
	}
}
