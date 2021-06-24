package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.controller.form.RankingForm;
import jp.co.example.dto.entity.Ranking;
import jp.co.example.dto.entity.RankingCategory;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.IRankingService;

@Controller
public class RankingController {

	@Autowired
	private IRankingService rs;
	@Autowired
	private HttpSession session;

	@RequestMapping("/rankingCategory")
	public String rankingCategory(@ModelAttribute("rankingCategoryForm") RankingForm form, Model model) {
		List<RankingCategory> categoryList = rs.selectAll();
		model.addAttribute("categoryList", categoryList);

		return "rankingCategory";
	}


	@RequestMapping("/rankingView")
	public String rankingView(@RequestParam(name = "categoryId", defaultValue = "0") Integer categoryId, Model model) {

		RankingCategory categoryName = rs.selectByCategoryId(categoryId);

		model.addAttribute("category", categoryName);

		ArrayList<Ranking> rankingList = rs.makeRanking(categoryId);
		model.addAttribute("rankingList", rankingList);

		//自分のランキングデータ
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		Ranking myRankingData = rs.searchMyData(rankingList, loginUserInfo.getUserId());
		model.addAttribute("myRankingData",myRankingData);

		int rankingUserNum = rs.rankingUserNum(categoryId);
		model.addAttribute("rankingUserNum", rankingUserNum);

		return "rankingView";


	}
}
