package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.BrandRepository;
import vp.spring.rcs.model.Brand;

@Service
public class BrandService {
	@Autowired
	BrandRepository brandRepository;

	public <S extends Brand> S save(S entity) {
		return brandRepository.save(entity);
	}

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	public Brand findOne(Long id) {
		return brandRepository.findOne(id);
	}

	public void delete(Long id) {
		brandRepository.delete(id);
	}

	public Brand getOne(Long id) {
		return brandRepository.getOne(id);
	}
	
}
