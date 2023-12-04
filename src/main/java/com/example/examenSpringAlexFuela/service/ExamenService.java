package com.example.examenSpringAlexFuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenSpringAlexFuela.model.Entrenador;
import com.example.examenSpringAlexFuela.model.Pokemon;
import com.example.examenSpringAlexFuela.model.Region;
import com.example.examenSpringAlexFuela.repository.ExamenRepository;

@Service
public class ExamenService {
	@Autowired
	ExamenRepository repository;
	
	public void insertRegion(Region regionx) {
		System.out.println("name" + regionx.getNombre());
		repository.insertRegion(regionx);
	}
	public void insertEntrenador(Entrenador entrenadorx) {
		System.out.println("name" + entrenadorx.getNombre());
		repository.insertEntrenador(entrenadorx);
	}
	
	public void insertPokemon(Pokemon pokemonx) {
		System.out.println("name" + pokemonx.getNombre());
		repository.insertPokemon(pokemonx);
	}
	//lista de pokemons 
	public List<Pokemon> listaPokemons(){
		List<Pokemon> listaPokemon = repository.findAllPokemons();
		for(Pokemon pokemonx : listaPokemon) {
			System.out.println(pokemonx.getId() + pokemonx.getNombre() + pokemonx.getRegion().getId() + pokemonx.getEntrenador().getId());
		}
		return listaPokemon;
	}
	
	//encontrar pokemon por id 
	public Pokemon findPokemonById(Integer id) {
		Pokemon pokemonx = repository.findePokemonByI(id);
		return pokemonx;
	}
	//borrar pokemon
	public void deletePokemon(Pokemon pokemonx) {
		repository.deletePokemon(pokemonx);
	}
}
