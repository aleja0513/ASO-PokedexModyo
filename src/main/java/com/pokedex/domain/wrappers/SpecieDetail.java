package com.pokedex.domain.wrappers;

import java.util.List;

public class SpecieDetail {
	
	
    private EvolutionChain evolution_chain;
    private List<FlavorTextEntry> flavor_text_entries;
    private List<Variety> varieties;
    
	public EvolutionChain getEvolution_chain() {
		return evolution_chain;
	}
	public void setEvolution_chain(EvolutionChain evolution_chain) {
		this.evolution_chain = evolution_chain;
	}
	public List<FlavorTextEntry> getFlavor_text_entries() {
		return flavor_text_entries;
	}
	public void setFlavor_text_entries(List<FlavorTextEntry> flavor_text_entries) {
		this.flavor_text_entries = flavor_text_entries;
	}
	public List<Variety> getVarieties() {
		return varieties;
	}
	public void setVarieties(List<Variety> varieties) {
		this.varieties = varieties;
	}
    
    

}
