package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.AdminForm;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.ICategoryService;

@Controller
public class AdminController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private HttpSession session;

	@RequestMapping(value="/admin")
	public String adminGet(@ModelAttribute("admin") AdminForm form, Model model) {
		/*ログインユーザーの情報が歩かないかの判断*/

		List<Category> categoryList = categoryService.selectAll();
		List<Category> parentCategoryList = categoryService.selectParentCategory();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("parentCategoryList", parentCategoryList);
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
		if (form.getCategoryName().isEmpty()) {
			model.addAttribute("isEmptyCategoryName", true);
			return "admin";
		}

		if ( categoryService.findByCategoryName(form.getCategoryName()).isEmpty() ) {
			categoryService.insert(form.getCategoryName(), 1, form.getCategoryParentCategoryId());
			return "redirect:/admin";
		}

		model.addAttribute("categoryNameExists", true);
		return "admin";
	}

	@RequestMapping(value="/admin", params="categoryEdit", method=RequestMethod.POST)
	public String adminPostCategoryEdit(@ModelAttribute("admin") AdminForm form, Model model) {
		if (form.getEditCategoryName().isEmpty()) {
			model.addAttribute("isEmptyEditCategoryName", true);
			return "admin";
		}

		List<Category> findCategory = categoryService.findByCategoryName(form.getEditCategoryName());
		if ( findCategory.isEmpty() &&
				!form.getEditCategoryName().equals(findCategory.get(0).getCategoryName()) &&
				form.getEditCategoryParentCategoryId() != findCategory.get(0).getParentCategoryId() ) {
			categoryService.update(
								form.getEditCategoryId(),
								form.getEditCategoryName(),
								form.getCategoryDisplay(),
								form.getEditCategoryParentCategoryId());
			return "redirect:/admin";
		} else if ( !form.getEditCategoryName().equals(findCategory.get(0).getCategoryName()) ) {
			model.addAttribute("categoryEditNameExists", true);
		} else {
			model.addAttribute("isChanged", true);
		}

		return "admin";
	}

	@RequestMapping(value="/admin", params="userEdit", method=RequestMethod.POST)
	public String adminPostUserEdit(@ModelAttribute("admin") AdminForm form, Model model) {
		System.out.println("userEdit");
		System.out.println(form);
		return "admin";
	}


}
