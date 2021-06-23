package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.example.dto.CategoryIdDTO;
import jp.co.example.dto.LoginIdDTO;
import jp.co.example.dto.QuizIdDTO;
import jp.co.example.dto.entity.Category;
import jp.co.example.dto.entity.Quiz;
import jp.co.example.dto.entity.UserInfo;
import jp.co.example.service.ICategoryService;
import jp.co.example.service.IUserInfoService;
import jp.co.example.service.QuizService;

@RestController
public class AsyncController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private QuizService quizService;
	@Autowired
	private HttpSession session;

	@RequestMapping(value="/categoryName", method=RequestMethod.POST)
	public Category categoryNamePost(@RequestBody CategoryIdDTO dto) {
		return categoryService.findByCategoryId(dto.getCategoryId()).get(0);
	}

	@RequestMapping(value="/userRole", method=RequestMethod.POST)
	public UserInfo userRolePost(@RequestBody LoginIdDTO dto) {
		return userInfoService.findByLoginId(dto.getLoginId());
	}

	@RequestMapping(value="/getQuizList", method=RequestMethod.POST)
	public List<Quiz> getQuizListPost(@RequestBody CategoryIdDTO dto) {
		return quizService.findByCategoryId(dto.getCategoryId());
	}

	@RequestMapping(value="/getQuiz", method=RequestMethod.POST)
	public Quiz getQuizPost(@RequestBody QuizIdDTO dto) {
		Quiz editQuiz = quizService.findByQuizId(dto.getQuizId());
		session.setAttribute("editQuiz", editQuiz);
		return editQuiz;
	}
}
