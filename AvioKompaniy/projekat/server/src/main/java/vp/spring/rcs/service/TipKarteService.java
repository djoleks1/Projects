package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.TipKarteRepository;
import vp.spring.rcs.model.TipKarte;

@Service
public class TipKarteService {

	@Autowired
	TipKarteRepository tipKarteRepository;

	public <S extends TipKarte> S save(S entity) {
		return tipKarteRepository.save(entity);
	}

	public Page<TipKarte> findAll(Pageable pageable) {
		return tipKarteRepository.findAll(pageable);
	}

	public List<TipKarte> findAll() {
		return tipKarteRepository.findAll();
	}

	public TipKarte findOne(Long id) {
		return tipKarteRepository.findOne(id);
	}

	public void delete(Long id) {
		tipKarteRepository.delete(id);
	}
	
	
}
