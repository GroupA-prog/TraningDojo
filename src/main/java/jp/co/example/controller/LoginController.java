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
import jp.co.example.dto.entity.Login;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	HttpSession session;
	@Autowired
	MessageSource messageSource;
	@Autowired
	private LoginService service;

	@RequestMapping("/login")
    public String login(@ModelAttribute("login") LoginForm form, Model model) {
        return "login";
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("login") LoginForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "login";
		}
		UserInfo user = service.authentication(form.getLoginId(), form.getPassword());
		if (user == null) {
			model.addAttribute("errMsg", "IDまたはパスワードが間違っています");
			return "login";
		} else {
			session.setAttribute("loginUserInfo", user);
			return "redirect:/userHome";
		}
	}

	@RequestMapping("/signUp")
    public String signUp(@ModelAttribute("signUp") InsertForm form, Model model) {
        return "signUp";
    }

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@Validated @ModelAttribute("signUp") InsertForm form, BindingResult bindingResult,
			Model model) {
//		System.out.println("aaaa");
		if (bindingResult.hasErrors()) {
			return "signUp";
		}
		if (service.existsUserByLoginId(form.getNewLoginId())) {
			model.addAttribute("errDuplicate", "そのIDは使用できません");
			return "signUp";
		}

		return "signUpConfirm";
	}

	@RequestMapping(value = "/signUpConfirm",method = RequestMethod.POST)
	public String signUpConfirm(@Validated @ModelAttribute("signUp") InsertForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "signUpConfirm";
		}

		if (!form.getNewPassword().equals(form.getNewPasswordRe())) {
			model.addAttribute("isNotMatchPassword", true);
			model.addAttribute("isNotMatchPasswordMsg","※パスワードが一致しません");
			return "signUpConfirm";
		}else {
			Login user = new Login(
					form.getNewLoginId(),
					form.getNewPassword(),
					form.getNewUserName());
			service.insert(user);
			return "redirect:/signUpDone";
		}
	}

	@RequestMapping(value = "/signUpDone")
	public String signUpDone(@ModelAttribute("signUpDone") LoginForm form, Model model) {
//		System.out.println("cccc");
		return "signUpDone";
	}

	@RequestMapping(value = "/signUpDone", method = RequestMethod.POST)
	public String signUpDone(@Validated @ModelAttribute("signUpDone") LoginForm form, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "signUpDone";
		}
		UserInfo user = service.authentication(form.getLoginId(), form.getPassword());
		if (user == null) {
			model.addAttribute("signUpErrMsg", "IDまたはパスワードが間違っています");
			return "signUpDone";
		} else {
			session.setAttribute("loginUserInfo", user);
			return "home";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}
}
