package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.LogForm;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.ICategoryService;

@Controller
public class LogController {
	@Autowired
	ICategoryService ICService;

	@Autowired
	HttpSession	session;

	//logCategory.jsp
	@RequestMapping(value="/logCategory")
	public String logCategory(Model model) {
		//ユーザーがログインしているか確認
		//sessionにログイン情報が保存されているか確認
		if(false) {
			return "redirect:/login";
		}

		//カテゴリ一覧を取得
		List<Category> categoryList = ICService.selectParentCategory();

		//取得したカテゴリ一覧をmodelに格納
		model.addAttribute("categoryList", categoryList);

		return "historyCategory";

	}

	//logList.jsp
	@RequestMapping(value="/logList", method=RequestMethod.GET)
	public String logList(@ModelAttribute("logList") LogForm form, Model model) {
		//ユーザーがログインしているか確認
		//sessionにログイン情報が保存されているか確認
		if(false) {
			return "redirect:/login";
		}

		//LogCategory.jspで選択したcategoryIdを受け取る
		Integer categoryId = form.getCategoryId();
		session.setAttribute("logSelectCategoryId", categoryId);	//ユーザーが選択したcategoryIdをsessionに保存

		//表示のためにcategoryIdからカテゴリ名取得
		List<Category> categoryList = ICService.findByCategoryId(categoryId);
		model.addAttribute("category", categoryList.get(0));

		System.out.println(categoryList);



		return "logList";
	}
}
