package jp.co.example.controller;

import java.util.Locale;

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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
			Model model) {

		String errMsg = messageSource.getMessage("login.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
            return "login";
        }
		UserInfo user = service.authentication(form.getLoginId(), form.getPassword());
		if (user == null) {
            model.addAttribute("errMsg", errMsg);
            return "login";
        } else {
        	session.setAttribute("userInfo",user);
        	return "home";
        }
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String signUp(@Validated @ModelAttribute("InsertForm") LoginForm form, BindingResult bindingResult,
			Model model) {
		return "signUp";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}
}
