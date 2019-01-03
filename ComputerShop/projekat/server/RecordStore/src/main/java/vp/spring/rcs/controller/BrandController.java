package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Brand;
import vp.spring.rcs.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	BrandService brandService;
	
	@GetMapping(value="/api/brands")
	public ResponseEntity<List<Brand>> getAll(){
		List<Brand> brands = brandService.findAll();
		return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
	}
	
}
