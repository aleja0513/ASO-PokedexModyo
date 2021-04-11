package com.pokedex.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.application.usescases.adapters.PokeService;
import com.pokedex.domain.entities.Pokemon;
import com.pokedex.domain.entities.Root;

@CrossOrigin("http://localhost:4200")
@RestController
public class PokeApiController {
	
	@Autowired
	PokeService service;
	
	@GetMapping("/getAllPokeList")
	public Root getPokeList(@RequestParam(defaultValue = "20") String limit, @RequestParam(defaultValue = "0") String offSet) {
		return service.getAll(limit, offSet);
	}
	
	@GetMapping("/getPokemon/{name}")
	public Pokemon getPokeList(@PathVariable("name") String name) {
		return service.getOne(name);
	}
	
}
