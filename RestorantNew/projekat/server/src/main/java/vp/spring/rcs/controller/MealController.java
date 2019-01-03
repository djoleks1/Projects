package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Meal;
import vp.spring.rcs.service.MealService;
import vp.spring.rcs.web.dto.CommonResponseDTO;

@RestController
@RequestMapping(value = "api/meals")
public class MealController {

	@Autowired
	MealService mealService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Meal>> findAll(Pageable pageable) {
		Page<Meal> meals = mealService.findAll(pageable);
		return new ResponseEntity<>(meals, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Meal> findOne(@PathVariable Long id) {
		Meal meal = mealService.findOne(id);

		return new ResponseEntity<>(meal, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Meal> save(@RequestBody Meal meal) {
		Meal m = mealService.save(meal);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<Meal> update(@PathVariable Long id, @RequestBody Meal meal) {
		Meal m = mealService.findOne(id);
		m.setName(meal.getName());
		m.setCategory(meal.getCategory());
		m.setPrice(meal.getPrice());
		m = mealService.save(m);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CommonResponseDTO> delete(@PathVariable Long id) {
		mealService.delete(id);
		return new ResponseEntity<>(new CommonResponseDTO("deleted"), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "mealName" })
	public ResponseEntity<List<Meal>> findByNameContains(@RequestParam String mealName) {
		List<Meal> meals = mealService.findByNameContains(mealName);

			return new ResponseEntity<>(meals, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET, params = { "categoryName" })
	public ResponseEntity<List<Meal>> findByCategoryNameContains(@RequestParam String categoryName) {
		List<Meal> meals = mealService.findByCategoryNameContains(categoryName);

		return new ResponseEntity<>(meals, HttpStatus.OK);

	}

}
