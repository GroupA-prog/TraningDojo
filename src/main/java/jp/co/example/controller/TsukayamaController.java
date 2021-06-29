package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.example.controller.form.EditUserForm;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.IUserInfoService;

@Controller
public class TsukayamaController {
	@Autowired
	private HttpSession session;
	@Autowired
	private IUserInfoService userInfoService;

	// プロフィール画面に遷移する時
	@RequestMapping(value="/profile")
	public String getProfile(@ModelAttribute("editUserInfo") EditUserForm form, BindingResult bindingResult, Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");

		if (loginUserInfo == null)
			return "redirect:/";

		form.setUserLoginId(loginUserInfo.getLoginId());
		return "profile";
	}

	// 入力画面の戻るボタン押下時
	@RequestMapping(value="/profile", params="returnUserHome")
	public String getProfile(Model model) {
		return "home";
	}

	// 確認画面の戻るボタン押下時
	@RequestMapping(value="/profile", params="returnProfile")
	public String returnProfile(@ModelAttribute("editUserInfo") EditUserForm form, BindingResult bindingResult, Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		form.setUserLoginId(loginUserInfo.getLoginId());
		return "profile";
	}

	// 確認画面へ遷移する時
	@RequestMapping(value="/profile", params="confirm", method=RequestMethod.POST)
	public String getProfilePostConfirm(@Validated @ModelAttribute("editUserInfo") EditUserForm form, BindingResult bindingResult, Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		if (bindingResult.hasErrors()) {
			List<FieldError> errorList = bindingResult.getFieldErrors();
			boolean result = false;
			for ( FieldError error : errorList ) {
//				if ( error.getField().equals("newPassword") || error.getField().equals("newUserName")
//						|| error.getField().equals("nowPassword")) {
//					return "profile";
//				}
				switch (error.getField()) {
					case "newPassword":
					case "newUserName":
					case "nowPassword":
						return "profile";
				}
			}
		}



		if ( userInfoService.findByUserANDPass(loginUserInfo.getLoginId(),form.getNowPassword()) == null) {
			model.addAttribute("isNotNowPassword",true);
			return "profile";
		}

		return "profileConfirm";
	}


	@RequestMapping(value="/profile", params="update", method=RequestMethod.POST)
	public String getProfilePostUpdate(@Validated @ModelAttribute("editUserInfo") EditUserForm form,
				BindingResult bindingResult, RedirectAttributes redirect, Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		System.out.println(form);
		if (bindingResult.hasErrors()) {
			if (bindingResult.getFieldError("reNewPassword") != null) {
				model.addAttribute("errorReNewPassword", true);
				return "profileConfirm";
			}
		}

		if ( !form.getNewPassword().equals(form.getReNewPassword())) {
			model.addAttribute("isNotMatchPassword",true);
			return "profileConfirm";
		}

		userInfoService.updateUserInfo(form.getNewPassword(), form.getNewUserName(), loginUserInfo.getUserId());
		loginUserInfo.setUserName(form.getNewUserName());
		loginUserInfo.setPassword(form.getNewPassword());
		redirect.addFlashAttribute("updateCompleted", true);

		return "redirect:/profile";
	}

}
