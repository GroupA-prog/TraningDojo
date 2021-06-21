package jp.co.example.controller;

import java.util.List;

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

	//logCategory.jsp
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public String logCategory(@ModelAttribute("logCategory") LogForm form, Model model) {
		//ユーザーがログインしているか確認
		//sessionにログイン情報が保存されているか確認
		if(false) {
			return "redirect:/login";
		}

		//カテゴリ一覧を取得
		List<Category> categoryList = ICService.selectParentCategory();

		//取得したカテゴリ一覧をmodelに格納
		model.addAttribute(categoryList);

		return "logCategory";

	}

	//logList.jsp
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public String logList(@ModelAttribute("logList") LogForm form, Model model) {
		//ユーザーがログインしているか確認
		//sessionにログイン情報が保存されているか確認
		if(false) {
			return "redirect:/login";
		}

		return "logList";
	}
}
