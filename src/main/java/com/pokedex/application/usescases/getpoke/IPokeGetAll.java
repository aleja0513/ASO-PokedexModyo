package com.pokedex.application.usescases.getpoke;

import com.pokedex.domain.models.Response;

public interface IPokeGetAll {
	
	public Response getAll(String limit, String offSet);
	
}
