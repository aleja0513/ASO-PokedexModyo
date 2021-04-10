package com.pokedex.application.usescases.getpoke;

import java.util.List;

import com.pokedex.domain.entities.Pokemon;

public interface IPokeGetAll {
	
	public List<Pokemon> getAll(String limit, String offSet);
	public Pokemon getOne(String id);
}
