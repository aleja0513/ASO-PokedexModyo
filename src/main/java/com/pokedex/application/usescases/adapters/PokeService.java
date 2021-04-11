package com.pokedex.application.usescases.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.application.usescases.getpoke.IPokeGetAll;
import com.pokedex.application.usescases.getpoke.IPokeGetOne;
import com.pokedex.domain.entities.Pokemon;
import com.pokedex.domain.entities.Root;
import com.pokedex.domain.models.PokeRestClientModel;
import com.pokedex.domain.wrappers.FlavorTextEntry;
import com.pokedex.domain.wrappers.Specie;


@Service
public class PokeService implements IPokeGetAll, IPokeGetOne{
	
	@Autowired
	PokeRestClientModel model;
	
	@Override
	public Root getAll(String limit, String offSet) {
		List<String> pokeEndPointLst =  model.getPokeList(limit, offSet);
		List<Pokemon> pokeList = new ArrayList<Pokemon>();
		Root root = new Root();
		
		for(int i=0; i < pokeEndPointLst.size() -1; i++){
			
			pokeList.add(new Pokemon( model.getPokemon(pokeEndPointLst.get(i)) ));
		}
		
		root.setList(pokeList);
		root.setCount(pokeEndPointLst.get(pokeEndPointLst.size()-1));
		return root;
	}

	@Override
	public Pokemon getOne(String name) {
		Pokemon poke;
		com.pokedex.domain.wrappers.Pokemon objPokeWrapper = model.getPokemonByName(name);
		
		poke = new Pokemon(objPokeWrapper);
		this.setDescriptions(poke, objPokeWrapper.getSpecies().getUrl());
		
		return poke;
	}
	
	
	private void setDescriptions(Pokemon poke , String url) {
		
		com.pokedex.domain.wrappers.SpecieDetail objWrapper = model.getSpecie(url);
		poke.getDescriptions().addAll(objWrapper.getFlavor_text_entries()
				.stream()
				.filter(f -> f.getLanguage().getName().equalsIgnoreCase("en"))
				.map(FlavorTextEntry::getFlavor_text).collect(Collectors.toList()));
		
		this.setEvolutions(poke, objWrapper.getEvolution_chain().getUrl());
	}
	
	private void setEvolutions(Pokemon poke , String url) {
		
		List<Specie> speciesEvol = model.getEvolution(url);
		
		for(int i =0; i < speciesEvol.size(); i++) {
			poke.getEvolutions().add(speciesEvol.get(i).getName());
		}
	}
	
	
	

	
	
}
