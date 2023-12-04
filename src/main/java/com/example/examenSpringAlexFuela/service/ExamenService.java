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
	//lista de pokemons 
	public List<Region> listaRegiones(){
		List<Region> listaRegiones = repository.findAllRegions();
		for(Region regionx : listaRegiones) {
			System.out.println(regionx.getId() + regionx.getNombre());
		}
		return listaRegiones;
	}
	
	//encontrar la region 
	public Region findRegionById(Integer id) {
		Region regionx = repository.findRegionByI(id);
		return regionx;
	}
	//borrar entrenadores
	public void deleteRegion(Region regionx) {
		repository.deleteRegion(regionx);
	}
	//lista de entrenadores 
	public List<Entrenador> listaEntrenadores(){
		List<Entrenador> listaEntrenadores = repository.findAllEntrenadores();
		for(Entrenador entrenadorx : listaEntrenadores) {
			System.out.println(entrenadorx.getId() + entrenadorx.getNombre() + entrenadorx.getActive());
		}
		return listaEntrenadores;
	}
	//encontrar un entrenador 
	public void updateActiveEntrenadorTrue(Integer id) {
		 repository.updateActiveEntrenadorTrue(id);
	}
	//lista pokemon de un entrenador 
	public List<Pokemon> listaPokemonsDeEntrenador(Integer id){
		List<Pokemon> listaPokemon = repository.findAllPokemonsFromEntrenador(id);
		for(Pokemon pokemonx : listaPokemon) {
			System.out.println(pokemonx.getId() + pokemonx.getNombre() + pokemonx.getRegion().getId() + pokemonx.getEntrenador().getId());
		}
		return listaPokemon;
	}
}
