package com.pokedex.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.application.usescases.adapters.PokeService;
import com.pokedex.domain.entities.Pokemon;


@RestController
public class PokeApiController {
	
	@Autowired
	PokeService service;
	
	@GetMapping("/getAllPokeList")
	public List<Pokemon> getPokeList(@RequestParam(defaultValue = "20") String limit, @RequestParam(required=false) String offSet) {
		return service.getAll(limit, offSet);
	}
	
}
