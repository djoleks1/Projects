package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.CategoryRepository;
import vp.spring.rcs.model.Category;

@Component
public class CategoryService {

	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	
}
