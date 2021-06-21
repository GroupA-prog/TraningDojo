package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.example.dto.CategoryIdDTO;
import jp.co.example.dto.entity.Category;
import jp.co.example.service.ICategoryService;

@RestController
public class AsyncController {
	@Autowired
	ICategoryService categoryService;

	@RequestMapping(value="/categoryName", method=RequestMethod.POST)
	public Category categoryNamePost(@RequestBody CategoryIdDTO dto) {
		return categoryService.findByCategoryId(dto.getCategoryId()).get(0);
	}
}