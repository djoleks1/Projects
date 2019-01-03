package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.ComputerPart;

import vp.spring.rcs.service.ComputerPartService;

@RestController
@RequestMapping(value = "/api/computer-parts")
public class ComputerPartController {

	
	@Autowired
	ComputerPartService computerPartService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ComputerPart>> getAll() {
		List<ComputerPart> computerParts= computerPartService.findAll();
		return new ResponseEntity<>(computerParts, HttpStatus.OK); 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<ComputerPart> save(@RequestBody ComputerPart computerPart){
		ComputerPart newComputerPart = computerPartService.save(computerPart);
		return new ResponseEntity<>(newComputerPart, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<ComputerPart> update(@PathVariable Long id, @RequestBody ComputerPart computerPart){
		ComputerPart editedComputerPart = computerPartService.findOne(id);
		editedComputerPart.setName(computerPart.getName());
		editedComputerPart.setPrice(computerPart.getPrice());
		editedComputerPart.setBrand(computerPart.getBrand());
		editedComputerPart= computerPartService.save(editedComputerPart);
		return new ResponseEntity<>(editedComputerPart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ComputerPart computerPart= computerPartService.findOne(id);
		if (computerPart!= null) {
			computerPartService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
