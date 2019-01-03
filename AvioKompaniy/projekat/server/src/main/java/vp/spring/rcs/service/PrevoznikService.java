package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.PrevoznikRepository;
import vp.spring.rcs.model.Prevoznik;

@Service
public class PrevoznikService {

	@Autowired
	PrevoznikRepository prevoznikRepository;

	public <S extends Prevoznik> S save(S entity) {
		return prevoznikRepository.save(entity);
	}

	public Page<Prevoznik> findAll(Pageable pageable) {
		return prevoznikRepository.findAll(pageable);
	}

	public List<Prevoznik> findAll() {
		return prevoznikRepository.findAll();
	}

	public Prevoznik findOne(Long id) {
		return prevoznikRepository.findOne(id);
	}

	public void delete(Long id) {
		prevoznikRepository.delete(id);
	}
	
	
}
