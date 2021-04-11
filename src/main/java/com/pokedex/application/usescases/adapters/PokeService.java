package com.pokedex.application.usescases.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.application.usescases.getpoke.IPokeGetAll;
import com.pokedex.application.usescases.getpoke.IPokeGetOne;
import com.pokedex.domain.entities.Pokemon;
import com.pokedex.domain.entities.Root;
import com.pokedex.domain.exceptions.ServiceNotAvailable;
import com.pokedex.domain.models.PokeRestClientModel;
import com.pokedex.domain.models.Response;
import com.pokedex.domain.wrappers.FlavorTextEntry;
import com.pokedex.domain.wrappers.Specie;


@Service
public class PokeService implements IPokeGetAll, IPokeGetOne{
	
	@Autowired
	PokeRestClientModel model;
	
	@Override
	public Response getAll(String limit, String offSet) {
		Response response = null;
		
		try {
			List<String> pokeEndPointLst =  model.getPokeList(limit, offSet);
			List<Pokemon> pokeList = new ArrayList<Pokemon>();
			Root root = new Root();
			
			for(int i=0; i < pokeEndPointLst.size() -1; i++){
				
				pokeList.add(new Pokemon( model.getPokemon(pokeEndPointLst.get(i)) ));
			}
			
			root.setList(pokeList);
			root.setCount(pokeEndPointLst.get(pokeEndPointLst.size()-1));
			ObjectMapper mapper = new ObjectMapper();
			response = new Response(mapper.writeValueAsString(root) ,200);
		}catch(JsonProcessingException jpro) {
			response = new Response(jpro.getMessage() ,404);
		}catch(ServiceNotAvailable exc) {
			response = new Response(exc.getMessage() ,404);
		}
		return response;
	}

	@Override
	public Response getOne(String name) {
		Response response = null;
		try {
		Pokemon poke;
		com.pokedex.domain.wrappers.Pokemon objPokeWrapper = model.getPokemonByName(name);
		
		poke = new Pokemon(objPokeWrapper);
		this.setDescriptions(poke, objPokeWrapper.getSpecies().getUrl());
		
		ObjectMapper mapper = new ObjectMapper();
		response = new Response(mapper.writeValueAsString(poke) ,200);
		
		}catch(JsonProcessingException jpro) {
			response = new Response(jpro.getMessage() ,404);
		}catch(ServiceNotAvailable exc) {
			response = new Response(exc.getMessage() ,404);
		}
		return response;
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
