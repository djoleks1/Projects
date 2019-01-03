package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.KartaRepositoty;
import vp.spring.rcs.model.Karta;

@Service
public class KartaService {

	@Autowired
	KartaRepositoty kartaRepositoty;

	public <S extends Karta> S save(S entity) {
		return kartaRepositoty.save(entity);
	}

	public Page<Karta> findAll(Pageable pageable) {
		return kartaRepositoty.findAll(pageable);
	}

	public List<Karta> findAll() {
		return kartaRepositoty.findAll();
	}

	public Karta findOne(Long id) {
		return kartaRepositoty.findOne(id);
	}

	public void deleteAll() {
		kartaRepositoty.deleteAll();
	}
	
	
}
