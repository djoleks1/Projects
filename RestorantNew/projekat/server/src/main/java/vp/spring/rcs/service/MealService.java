package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.MealRepository;
import vp.spring.rcs.model.Meal;

@Service
public class MealService {

	
	@Autowired
	MealRepository mealRepository;

	public <S extends Meal> S save(S entity) {
		return mealRepository.save(entity);
	}

	public Page<Meal> findAll(Pageable pageable) {
		return mealRepository.findAll(pageable);
	}

	public List<Meal> findAll() {
		return mealRepository.findAll();
	}

	public Meal findOne(Long id) {
		return mealRepository.findOne(id);
	}

	public void delete(Long id) {
		mealRepository.delete(id);
	}
	
	public List<Meal> findByNameContains(String mealName) {
		return mealRepository.findByNameContains(mealName);
	}
	
	public List<Meal> findByCategoryNameContains(String categoryName) {
		return mealRepository.findByCategoryNameContains(categoryName);
	}
	
}
