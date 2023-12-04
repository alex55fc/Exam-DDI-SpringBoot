package com.example.examenSpringAlexFuela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.examenSpringAlexFuela.model.Entrenador;
import com.example.examenSpringAlexFuela.model.Pokemon;
import com.example.examenSpringAlexFuela.model.Region;
import com.example.examenSpringAlexFuela.service.ExamenService;

@Controller
public class ExamenController {

	@Autowired
	ExamenService service;

	@RequestMapping("/")
	public String index(Model model) {
		//necesario para que el formulario funcione
		//como no tiene constructor me deja crear un duenio vacio sin atributos asociados
		model.addAttribute("regionx", new Region());
		model.addAttribute("entrenadorx", new Entrenador());
		model.addAttribute("pokemonx", new Pokemon());
		
		return "index";
		
	}
	
	@RequestMapping("/insertRegion")
	public String insertRegion(Region region, Model model) {
		service.insertRegion(region);
		model.addAttribute("mensajeRegion", "Region added");
		
		List<Entrenador> listaEntrenadores = service.listaEntrenadores();
		model.addAttribute("listaEntrenadores", listaEntrenadores);

		List<Pokemon> listaPokemons = service.listaPokemons();
		model.addAttribute("listaPokemons", listaPokemons);
		
		List<Region> listaRegiones = service.listaRegiones();
		model.addAttribute("listaRegiones", listaRegiones);
		
		return "fin";
	}
	
	@RequestMapping("/insertEntrenador")
	public String insertEntrenador(Entrenador entrenador, Model model) {
		service.insertEntrenador(entrenador);
		model.addAttribute("mensajeEntre", "Entrenador added");
		
		List<Entrenador> listaEntrenadores = service.listaEntrenadores();
		model.addAttribute("listaEntrenadores", listaEntrenadores);

		List<Pokemon> listaPokemons = service.listaPokemons();
		model.addAttribute("listaPokemons", listaPokemons);
		
		List<Region> listaRegiones = service.listaRegiones();
		model.addAttribute("listaRegiones", listaRegiones);
		
		return "fin";
	}
	@RequestMapping("/insertPokemon")
	public String insertPokemon(Pokemon pokemon, Model model) {
		service.insertPokemon(pokemon);
		model.addAttribute("mensajePokemon", "Pokemon added");
	
		List<Entrenador> listaEntrenadores = service.listaEntrenadores();
		model.addAttribute("listaEntrenadores", listaEntrenadores);

		List<Pokemon> listaPokemons = service.listaPokemons();
		model.addAttribute("listaPokemons", listaPokemons);
		
		List<Region> listaRegiones = service.listaRegiones();
		model.addAttribute("listaRegiones", listaRegiones);
		return "fin";
	}
	@RequestMapping("/deletePokemonById/{id}")
	public String deletePokemon(@PathVariable Integer id, Model model) {
		Pokemon pokemonx = service.findPokemonById(id);
		service.deletePokemon(pokemonx);
		model.addAttribute("mensajePokemon", "Pokemon deleted");
		
		List<Entrenador> listaEntrenadores = service.listaEntrenadores();
		model.addAttribute("listaEntrenadores", listaEntrenadores);

		List<Pokemon> listaPokemons = service.listaPokemons();
		model.addAttribute("listaPokemons", listaPokemons);
		
		List<Region> listaRegiones = service.listaRegiones();
		model.addAttribute("listaRegiones", listaRegiones);
		
		return "fin";
	}
	@RequestMapping("/deleteRegionById/{id}")
	public String deleteRegion(@PathVariable Integer id, Model model) {
		Region regionx = service.findRegionById(id);
		service.deleteRegion(regionx);
		model.addAttribute("mensajeRegion", "Region deleted");
		
		List<Entrenador> listaEntrenadores = service.listaEntrenadores();
		model.addAttribute("listaEntrenadores", listaEntrenadores);

		List<Pokemon> listaPokemons = service.listaPokemons();
		model.addAttribute("listaPokemons", listaPokemons);
		
		List<Region> listaRegiones = service.listaRegiones();
		model.addAttribute("listaRegiones", listaRegiones);
		
		return "fin";
	}
	@RequestMapping("/deletePokemonsEntrenadorActivoById/{id}")
	public String deletePokemonsEntrenadorActivoById(@PathVariable Integer id, Model model) {
		 service.updateActiveEntrenadorTrue(id);
				
		List<Entrenador> listaEntrenadores = service.listaEntrenadores();
		model.addAttribute("listaEntrenadores", listaEntrenadores);

		List<Pokemon> listaPokemons = service.listaPokemons();
		model.addAttribute("listaPokemons", listaPokemons);
		
		List<Region> listaRegiones = service.listaRegiones();
		model.addAttribute("listaRegiones", listaRegiones);
		
		return "fin";
	}
	
}
