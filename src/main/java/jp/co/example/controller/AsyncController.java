package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.example.dto.CategoryIdDTO;
import jp.co.example.dto.LoginIdDTO;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.IUserInfoService;

@RestController
public class AsyncController {
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IUserInfoService userInfoService;

	@RequestMapping(value="/categoryName", method=RequestMethod.POST)
	public Category categoryNamePost(@RequestBody CategoryIdDTO dto) {
		return categoryService.findByCategoryId(dto.getCategoryId()).get(0);
	}

	@RequestMapping(value="/userRole", method=RequestMethod.POST)
	public UserInfo userRolePost(@RequestBody LoginIdDTO dto) {
		System.out.println(dto.getLoginId());
		return userInfoService.findByLoginId(dto.getLoginId());
	}

	@RequestMapping(value="/getQuizList", method=RequestMethod.POST)
	public List<Quiz> getQuizListPost(@RequestBody CategoryIdDTO dto) {
		System.out.println(dto);
		return new ArrayList();
	}
}
