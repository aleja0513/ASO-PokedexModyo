package com.pokedex.application.usescases.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokedex.application.usescases.getpoke.IPokeGetAll;
import com.pokedex.application.usescases.getpoke.IPokeGetOne;
import com.pokedex.domain.entities.Pokemon;


@Service
public class PokeService implements IPokeGetAll, IPokeGetOne{

	@Override
	public List<Pokemon> getAll(String limit, String offeSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
