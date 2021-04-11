package com.pokedex.domain.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.domain.wrappers.Pokemon;
import com.pokedex.domain.wrappers.Specie;
import com.pokedex.domain.wrappers.SpecieDetail;

@Service
public class PokeRestClientModel {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
		
	public List<String> getPokeList(String limit, String offSet) {
		List<String> retorno = new ArrayList<String>();
		
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(env.getProperty("app.apiurl")).queryParam("limit",limit).queryParam("offset",offSet).build();
		
		var response =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,  String.class);
		
	    if (response.getStatusCode() == HttpStatus.OK) {
	        var jsonString = response.getBody();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode actualObj = null;
			try {
				actualObj = mapper.readTree(jsonString);
			} catch (JsonProcessingException e) {
			
			}           
	        
			retorno = actualObj.get("results").findValuesAsText("url");
			retorno.add(actualObj.get("count").asText());
	    }
	    
		return retorno;
	}
	

	
	public Pokemon getPokemon(String url) {
		Pokemon objPokemonWrapper = null;
		ResponseEntity<Pokemon>  response = restTemplate.exchange(url, 
																HttpMethod.GET,
																null,
																new ParameterizedTypeReference<Pokemon>() {});
		 if (response.getStatusCode() == HttpStatus.OK) {
			 objPokemonWrapper = response.getBody();
		 }
		
		 return objPokemonWrapper;
	}
	
	public Pokemon getPokemonByName(String name) {
		Pokemon objPokemonWrapper = null;
		ResponseEntity<Pokemon>  response = restTemplate.exchange(env.getProperty("app.apiurl")+name, 
																HttpMethod.GET,
																null,
																new ParameterizedTypeReference<Pokemon>() {});
		 if (response.getStatusCode() == HttpStatus.OK) {
			 objPokemonWrapper = response.getBody();
		 }
		
		 return objPokemonWrapper;
	}
	
	public SpecieDetail getSpecie(String url) {
		SpecieDetail objSpecieWrapper = null;
		ResponseEntity<SpecieDetail>  response = restTemplate.exchange(url, 
																HttpMethod.GET,
																null,
																new ParameterizedTypeReference<SpecieDetail>() {});
		 if (response.getStatusCode() == HttpStatus.OK) {
			 objSpecieWrapper = response.getBody();
		 }
		
		 return objSpecieWrapper;
	}
	
	
	public List<Specie> getEvolution(String url) {
		List<Specie> retorno = new ArrayList<Specie>();
		var response =  restTemplate.exchange(url, HttpMethod.GET, null,  String.class);
		
	    if (response.getStatusCode() == HttpStatus.OK) {
	        var jsonString = response.getBody();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode actualObj = null;
			try {
				actualObj = mapper.readTree(jsonString);
			} catch (JsonProcessingException e) {
			
			}       
			
			List<JsonNode> species =  actualObj.get("chain").findValues("species");
			
			for(JsonNode node:species) {
				try {
					retorno.add(mapper.treeToValue(node, Specie.class));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
			
	    }
	    
		return retorno;
	}

}
