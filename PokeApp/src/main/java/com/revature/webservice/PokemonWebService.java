package com.revature.webservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

public class PokemonWebService {
	public static void getPokemon(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Pokemon p = PokemonService.getPokemon(id);
		ObjectMapper om = new ObjectMapper();
		try {
			String pokeJSON = om.writeValueAsString(p);
			response.getWriter().append(pokeJSON).close();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void addPokemon(HttpServletRequest request, HttpServletResponse response) {
		int id =Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("name");
		String t=request.getParameter("type");
		PokemonService.addPokemon(new Pokemon(id,name,t));
		try {
			response.getWriter().append("Pokemon Added to DB").close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void getAllPokemon(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Pokemon> poks = 
				PokemonService.getAllPokemon();
		ObjectMapper om = new ObjectMapper();
		try {
			response.getWriter().append(om.writeValueAsString(poks));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
