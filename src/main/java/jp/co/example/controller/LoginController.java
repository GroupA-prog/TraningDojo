package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.LoginForm;

@Controller
public class LoginController {
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
			Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}
}
