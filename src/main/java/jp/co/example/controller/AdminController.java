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
import jp.co.example.dao.QuizDao;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.IUserInfoService;

@Controller
public class AdminController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private QuizDao QuizDaoImpl;
	@Autowired
	private HttpSession session;

	@RequestMapping(value="/admin")
	public String adminGet(@ModelAttribute("admin") AdminForm form, Model model) {
		/*ログインユーザーの情報が歩かないかの判断*/

		List<Category> categoryList 			= categoryService.selectAll();
		List<Category> parentCategoryList 	= categoryService.selectParentCategory();
		List<UserInfo> userInfoList 			= userInfoService.selectAll();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("parentCategoryList", parentCategoryList);
		session.setAttribute("userInfoList", userInfoList);
		//初期値設定
		form.setRole( userInfoList.get(0).getRole());
		return "admin";
	}

	@RequestMapping(value="/admin", params="quizCreate", method=RequestMethod.POST)
	public String adminPostQuizCreate(@ModelAttribute("admin") AdminForm form, Model model) {
		boolean categoryFlg 	     = form.getQuizCategoryId() == null ? true : false;
		boolean quizTitleFlg 	 = form.getCreateQuizTitle().isEmpty();
		boolean problemStatementFlg = form.getCreateProblemStatement().isEmpty();
		boolean choice1Flg  = form.getCreateChoice1().isEmpty();
		boolean choice2Flg  = form.getCreateChoice2().isEmpty();
		boolean choice3Flg  = form.getCreateChoice3().isEmpty();
		boolean choice4Flg  = form.getCreateChoice4().isEmpty();

		//入力チェック
		if ( categoryFlg || quizTitleFlg || problemStatementFlg || choice1Flg
				|| choice2Flg || choice3Flg || choice4Flg) {
			model.addAttribute("isNotCategory", categoryFlg);
			model.addAttribute("isNotSentence", problemStatementFlg);
			model.addAttribute("isNotChoices", choice1Flg || choice2Flg || choice3Flg || choice4Flg);
			model.addAttribute("isNotQuizTitle", quizTitleFlg);
			return "admin";
		}

		


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
			model.addAttribute("admin", form);
			return "admin";
		}

		List<Category> findCategory = categoryService.findByCategoryName(form.getEditCategoryName());
		//System.out.println(form);
		//System.out.println(findCategory.get(0));
		if (!findCategory.isEmpty()) {
			if (form.getEditCategoryName().equals(findCategory.get(0).getCategoryName()) &&
				form.getEditCategoryParentCategoryId().equals(findCategory.get(0).getParentCategoryId()) &&
				form.getCategoryDisplay().equals(findCategory.get(0).getDisplay()) ) {

				model.addAttribute("isChanged", true);
				return "admin";
			} else if ( form.getEditCategoryName().equals(findCategory.get(0).getCategoryName()) &&
						 !form.getEditCategoryId().equals(findCategory.get(0).getCategoryId()) ) {
				model.addAttribute("categoryEditNameExists", true);
				return "admin";
			}
		}
		//データの更新
		categoryService.update(
				form.getEditCategoryId(),
				form.getEditCategoryName(),
				form.getCategoryDisplay(),
				form.getEditCategoryParentCategoryId());

		return "redirect:/admin";
	}

	@RequestMapping(value="/admin", params="userEdit", method=RequestMethod.POST)
	public String adminPostUserEdit(@ModelAttribute("admin") AdminForm form, Model model) {
		userInfoService.updateRole(form.getLoginId(), form.getRole());
		return "redirect:/admin";
	}


}
