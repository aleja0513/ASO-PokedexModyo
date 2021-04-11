package com.pokedex.application.usescases.getpoke;

import java.util.List;

import com.pokedex.domain.entities.Pokemon;
import com.pokedex.domain.entities.Root;

public interface IPokeGetAll {
	
	public Root getAll(String limit, String offSet);
	
}
