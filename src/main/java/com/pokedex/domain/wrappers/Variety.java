package com.pokedex.domain.wrappers;

public class Variety {

	
	private boolean is_default;
	private Pokemon pokemon;
	
	
	public boolean isIs_default() {
		return is_default;
	}
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	
}
