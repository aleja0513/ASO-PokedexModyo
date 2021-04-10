package com.pokedex.domain.wrappers;

import java.util.List;

public class Pokemon {
	
	
	private int height;
	private int id;
	private String name;
	private Specie species;
	private Sprite sprites;
	private List<Type> types;
	private int weight;
	public List<Ability> abilities;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Specie getSpecies() {
		return species;
	}
	public void setSpecies(Specie species) {
		this.species = species;
	}
	public Sprite getSprites() {
		return sprites;
	}
	public void setSprites(Sprite sprites) {
		this.sprites = sprites;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

}
