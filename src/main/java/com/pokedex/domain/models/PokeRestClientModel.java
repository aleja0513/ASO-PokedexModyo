package com.pokedex.domain.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.domain.wrappers.Pokemon;

@Service
public class PokeRestClientModel {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
		
	public List<String> getPokeList(String limit, String offSet) {
		List<String> retorno = new ArrayList<String>();

		var response =  restTemplate.exchange(env.getProperty("app.apiurl"), HttpMethod.GET, null,  String.class);
		
	    if (response.getStatusCode() == HttpStatus.OK) {
	        var jsonString = response.getBody();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode actualObj = null;
			try {
				actualObj = mapper.readTree(jsonString);
			} catch (JsonProcessingException e) {
			
			}           
	        
			retorno = actualObj.get("results").findValuesAsText("url");

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

}
