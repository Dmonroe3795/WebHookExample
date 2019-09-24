package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.db.fakeDB;
import com.revature.model.Pokemon;

public class PokemonService {
	
	public static Pokemon getPokemon(int id) {
		return fakeDB.team.get(id);
	}
	public static void addPokemon(Pokemon p) {
		fakeDB.team.put(p.getId(),p);	
	}
	public static ArrayList<Pokemon> getAllPokemon() {
		// TODO Auto-generated method stub
		return new ArrayList<Pokemon>(fakeDB.team.values());
	}

}
