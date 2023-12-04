package com.example.examenSpringAlexFuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "fin";
	}
	
	@RequestMapping("/insertEntrenador")
	public String insertEntrenador(Entrenador entrenador, Model model) {
		service.insertEntrenador(entrenador);
		model.addAttribute("mensajeEntre", "Entrenador added");
		return "fin";
	}
	@RequestMapping("/insertPokemon")
	public String insertPokemon(Pokemon pokemon, Model model) {
		service.insertPokemon(pokemon);
		model.addAttribute("mensajePokemon", "Pokemon added");
		return "fin";
	}
}
