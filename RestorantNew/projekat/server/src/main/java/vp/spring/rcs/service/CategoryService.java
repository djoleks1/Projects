package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.CategoryRepository;
import vp.spring.rcs.model.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;


	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
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
	
	

}
