package com.pokedex.application.usescases.adapters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.application.usescases.getpoke.IPokeGetAll;
import com.pokedex.application.usescases.getpoke.IPokeGetOne;
import com.pokedex.domain.entities.Pokemon;
import com.pokedex.domain.models.PokeRestClientModel;


@Service
public class PokeService implements IPokeGetAll, IPokeGetOne{
	
	@Autowired
	PokeRestClientModel model;
	
	@Override
	public List<Pokemon> getAll(String limit, String offSet) {
		List<String> pokeEndPointLst =  model.getPokeList(limit, offSet);
		List<Pokemon> pokeList = new ArrayList<Pokemon>();
		
		for(int i=0; i < pokeEndPointLst.size(); i++){
			
			pokeList.add(new Pokemon( model.getPokemon(pokeEndPointLst.get(i)) ));
		}
		return pokeList;
	}

	@Override
	public Pokemon getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
