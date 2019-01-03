package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Category;
import vp.spring.rcs.service.CategoryService;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Category>> findAll() {
		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

}