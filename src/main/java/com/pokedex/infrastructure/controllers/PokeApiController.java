package com.pokedex.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.application.usescases.adapters.PokeService;
import com.pokedex.domain.models.Response;

@CrossOrigin("http://localhost:4200")
@RestController
public class PokeApiController {
	
	@Autowired
	PokeService service;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getAllPokeList")
	public ResponseEntity<Response>  getPokeList(@RequestParam(defaultValue = "20") String limit, @RequestParam(defaultValue = "0") String offSet) {
		Response res = service.getAll(limit, offSet);
		return new ResponseEntity(res, res.getRespondeCode()==200?HttpStatus.OK:HttpStatus.NOT_FOUND );
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getPokemon/{name}")
	public ResponseEntity<Response>  getPokeList(@PathVariable("name") String name) {
		Response res =  service.getOne(name);
		return new ResponseEntity(res, res.getRespondeCode()==200?HttpStatus.OK:HttpStatus.NOT_FOUND );
	}
	
}
