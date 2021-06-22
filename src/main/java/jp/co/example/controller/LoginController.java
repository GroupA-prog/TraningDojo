package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.InsertForm;
import jp.co.example.controller.form.LoginForm;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.impl.UserInfoService;

@Controller
public class LoginController {
	@Autowired
	HttpSession session;
	@Autowired
    MessageSource messageSource;
	@Autowired
    private UserInfoService service;

	@RequestMapping(value = "/login")
	public String login(@Validated @ModelAttribute("login") LoginForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
            return "login";
        }
		UserInfo user = service.authentication(form.getLoginId(), form.getPassword());
		if (user == null) {
            model.addAttribute("errMsg","");
            return "login";
        } else {
        	session.setAttribute("userInfo",user);
        	return "home";
        }
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@Validated @ModelAttribute("signUp") InsertForm form, BindingResult bindingResult,
			Model model) {
		return "signUp";
	}
	@RequestMapping(value = "/signUpDone", method = RequestMethod.POST)
	public String signUpDone(@Validated @ModelAttribute("signUpDone") InsertForm form, BindingResult bindingResult,
			Model model) {
		return "signUpDone";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}
}
