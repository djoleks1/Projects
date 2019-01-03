package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Avion;
import vp.spring.rcs.service.AvionService;
import vp.spring.rcs.web.dto.CommonResponseDTO;

@RestController
@RequestMapping (value = "/api/letovi")
public class AvionController {

	@Autowired
	AvionService letService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Avion>> findAll(Pageable pageable) {
		Page<Avion> letovi = letService.findAll(pageable);
		return new ResponseEntity<>(letovi, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Avion> findOne(@PathVariable Long id) {
		Avion let = letService.findOne(id);

		return new ResponseEntity<>(let, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Avion> save(@RequestBody Avion let) {
		Avion l = letService.save(let);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<Avion> update(@PathVariable Long id, @RequestBody Avion let) {
		Avion l = letService.findOne(id);
		l.setBrojLeta(let.getBrojLeta());
		l.setVremeLeta(let.getVremeLeta());
		l.setKarta(let.getKarta());
		l.setPrevoznik(let.getPrevoznik());
		l = letService.save(l);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CommonResponseDTO> delete(@PathVariable Long id) {
		letService.delete(id);
		return new ResponseEntity<>(new CommonResponseDTO("deleted"), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "vreme" })
	public ResponseEntity<List<Avion>> findByVremeLetaContains(@RequestParam String vreme) {
		List<Avion> letovi = letService.findByVremeLetaContains(vreme);

			return new ResponseEntity<>(letovi, HttpStatus.OK);
		
	}
}
