package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.AvionRepository;
import vp.spring.rcs.model.Avion;


@Service
public class AvionService {
	@Autowired
	AvionRepository letRepository;

	public <S extends Avion> S save(S entity) {
		return letRepository.save(entity);
	}

	public Page<Avion> findAll(Pageable pageable) {
		return letRepository.findAll(pageable);
	}

	public List<Avion> findAll() {
		return letRepository.findAll();
	}

	public Avion findOne(Long id) {
		return letRepository.findOne(id);
	}

	public void delete(Long id) {
		letRepository.delete(id);
	}
	
	public List<Avion> findByVremeLetaContains(String vreme) {
		return letRepository.findByVremeLetaContains(vreme);
	}

}
