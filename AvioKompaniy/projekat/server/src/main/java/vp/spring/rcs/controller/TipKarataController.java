package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.TipKarte;
import vp.spring.rcs.service.TipKarteService;

@RestController
@RequestMapping(value="api/tipovikarata")
public class TipKarataController {

	@Autowired
	TipKarteService tipKarteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TipKarte>> getAll(){
		List<TipKarte> tipoviKarata = tipKarteService.findAll();
		return new ResponseEntity<List<TipKarte>>(tipoviKarata, HttpStatus.OK);
	}
}
