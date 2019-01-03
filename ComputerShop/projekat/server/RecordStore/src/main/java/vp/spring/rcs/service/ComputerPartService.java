package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ComputerPartRepository;
import vp.spring.rcs.model.ComputerPart;

@Component
public class ComputerPartService {

	@Autowired
	ComputerPartRepository computerPartRepository;

	public ComputerPart save(ComputerPart computerPart) { 
		return computerPartRepository.save(computerPart);
	}

	public List<ComputerPart> findAll() {
		return computerPartRepository.findAll();
	}

	public ComputerPart findOne(Long id) {
		return computerPartRepository.findOne(id);
	}

	public void delete(Long id) {
		computerPartRepository.delete(id);
	}
	
	
	
	
}
