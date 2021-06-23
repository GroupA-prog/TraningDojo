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

import jp.co.example.controller.form.EditUserForm;
import jp.co.example.dto.entity.UserInfo;

@Controller
public class TsukayamaController {
	@Autowired
	private HttpSession session;

	@RequestMapping(value="/profile")
	public String getProfile(@ModelAttribute("editUserInfo") EditUserForm form, BindingResult bindingResult, Model model) {
		UserInfo loginUserInfo = (UserInfo) session.getAttribute("loginUserInfo");
		form.setUserLoginId(loginUserInfo.getLoginId());
		return "profile";
	}


	@RequestMapping(value="/profile", params="confirm", method=RequestMethod.POST)
	public String getProfilePostConfirm(@Validated @ModelAttribute("editUserInfo") EditUserForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<FieldError> errorList = bindingResult.getFieldErrors();
			for ( FieldError error : errorList ) {
				System.out.println(error.getField());
			}

			return "profile";
		}

		return "profile";
	}

}
