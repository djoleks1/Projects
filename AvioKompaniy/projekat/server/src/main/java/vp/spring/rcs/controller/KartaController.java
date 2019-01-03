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

import vp.spring.rcs.model.Karta;
import vp.spring.rcs.service.KartaService;

@RestController
@RequestMapping(value = "api/karte")
public class KartaController {
	
	@Autowired
	KartaService kartaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Karta>> getAll(){
		List<Karta> karte = kartaService.findAll();
		return new ResponseEntity<List<Karta>>(karte, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Karta> save(@RequestBody Karta karta) {
		Karta k = kartaService.save(karta);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<Karta> update(@PathVariable Long id, @RequestBody Karta karta) {
		Karta k = kartaService.findOne(id);
		k.setIme(karta.getIme());
		k.setPrezime(karta.getPrezime());
		k.setBrojSedista(karta.getBrojSedista());
		k.setTipKarte(karta.getTipKarte());
		k = kartaService.save(k);
		return new ResponseEntity<>(k, HttpStatus.OK);
	}

}
