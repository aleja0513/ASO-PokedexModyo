package com.pokedex.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pokedex.domain.wrappers.Ability;
import com.pokedex.domain.wrappers.Ability2;
import com.pokedex.domain.wrappers.Type;
import com.pokedex.domain.wrappers.Type2;

public class Pokemon {
	
	private String name;
	private String photo;
	private List<String> types;
	private List<String> abilities;
	private String weight;
	private List<String> descriptions;
	private List<String> evolutions;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public List<String> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public List<String> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public Pokemon (com.pokedex.domain.wrappers.Pokemon poke) {
		
		this.name = poke.getName();
		this.photo = poke.getSprites().getFront_default();
		this.weight = String.valueOf(poke.getWeight());
		this.descriptions = new ArrayList<String>();
		this.evolutions = new ArrayList<String>();
		if(poke.getTypes() != null && poke.getTypes().size() > 0) {
			this.types = poke.getTypes().stream().map(Type::getType).map(Type2::getName).collect(Collectors.toList());
		}
		
		if(poke.getAbilities() != null && poke.getAbilities().size() > 0) {
			this.abilities = poke.getAbilities().stream().map(Ability::getAbility).map(Ability2::getName).collect(Collectors.toList());
		}
		
		
	}
	public List<String> getEvolutions() {
		return evolutions;
	}
	public void setEvolutions(List<String> evolutions) {
		this.evolutions = evolutions;
	}



}
