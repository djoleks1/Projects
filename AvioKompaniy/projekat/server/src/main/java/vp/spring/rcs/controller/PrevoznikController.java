package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import vp.spring.rcs.model.Prevoznik;
import vp.spring.rcs.service.PrevoznikService;

@RestController
@RequestMapping(value = "api/prevoznici")
public class PrevoznikController {
	
	@Autowired
	PrevoznikService prevoznikService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Prevoznik>> getAll(){
		List<Prevoznik> prevoznici = prevoznikService.findAll();
		return new ResponseEntity<List<Prevoznik>>(prevoznici, HttpStatus.OK);
	}

}
