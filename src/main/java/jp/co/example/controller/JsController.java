package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.example.controller.form.QuizForm;
import jp.co.example.dto.CategoryIdDTO;
import jp.co.example.dto.entity.Home;
import jp.co.example.service.HomeService;
import jp.co.example.service.QuizConfigService;

@RestController
public class JsController {

	@Autowired
	private QuizConfigService quizConfigService;
	@Autowired
	private HomeService homeService;

	@RequestMapping(path = "/numJs", method = RequestMethod.POST)
	public int numJs(@RequestBody QuizForm form) {
		int num = quizConfigService.categoryNum(form.getCategoryId());

		return num;
	}

	@RequestMapping(path = "/categoryJs", method = RequestMethod.POST)
	public List<Home> categoryJs(@RequestBody CategoryIdDTO form) {
		List<Home> radarList = homeService.answerLateList(form.getCategoryId());
		List<Home> list = new ArrayList<>();
		list.addAll(radarList);
		System.out.print(form.getCategoryId());
		return list;
	}
}
