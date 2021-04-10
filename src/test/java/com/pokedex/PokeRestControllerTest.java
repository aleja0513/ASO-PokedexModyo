package com.pokedex;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.pokedex.infrastructure.controllers.PokeApiController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PokeApiController.class)
public class PokeRestControllerTest {

	
	@Autowired
	private MockMvc mvc;
	 
	@Test
	public void prueba() throws Exception {
	    mvc.perform(get("/getAllPokeList?limit=20&offset=0").contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
}
