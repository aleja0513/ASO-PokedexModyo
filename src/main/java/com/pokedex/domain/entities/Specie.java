package com.pokedex.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Specie {
	
	private String name;
	private List<Pokemon> variety;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pokemon> getVariety() {
		return variety;
	}
	public void setVariety(List<Pokemon> variety) {
		this.variety = variety;
	}
	
	public Specie(String name) {
		
		variety = new ArrayList<Pokemon>();
	}
	

}
