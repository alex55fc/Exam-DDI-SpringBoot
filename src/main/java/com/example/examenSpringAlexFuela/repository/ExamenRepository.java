package com.example.examenSpringAlexFuela.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.examenSpringAlexFuela.model.Entrenador;
import com.example.examenSpringAlexFuela.model.EntrenadorRowMapper;
import com.example.examenSpringAlexFuela.model.Pokemon;
import com.example.examenSpringAlexFuela.model.PokemonRowMapper;
import com.example.examenSpringAlexFuela.model.Region;
import com.example.examenSpringAlexFuela.model.RegionRowMapper;

@Repository
public class ExamenRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public void insertRegion(Region region) {
		jdbcTemplate.update("insert into region(nombre) values(?);",
				region.getNombre());
	}

	public void insertEntrenador(Entrenador entrenador) {
		jdbcTemplate.update("insert into entrenador(nombre, active) values(?,?);",
				entrenador.getNombre(), entrenador.getActive());
	}
	
	public void insertPokemon(Pokemon pokemon) {
		jdbcTemplate.update("insert into pokemon(nombre, region, entrenador_id ) values(?,?,?);",
				pokemon.getNombre(), pokemon.getRegion().getId(), pokemon.getEntrenador().getId());
	}
	//all pokemons
	public List<Pokemon> findAllPokemons(){
		return jdbcTemplate.query("SELECT * FROM pokemon", new PokemonRowMapper() );
	}
	//find pokemon by id 
	public Pokemon findePokemonByI(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM pokemon WHERE id =?",
				new PokemonRowMapper(), id );
	}
	//borrar un pokemo
	public void deletePokemon(Pokemon pokemonx) {
		jdbcTemplate.update("DELETE FROM pokemon WHERE id=?", pokemonx.getId());
	}
	//all regions
	public List<Region> findAllRegions(){
		return jdbcTemplate.query("SELECT * FROM region", new RegionRowMapper() );
	}
	
	public Region findRegionByI(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM region WHERE id =?",
				new RegionRowMapper(), id );
	}
	//borrar un pokemo
	public void deleteRegion(Region regionx) {
		jdbcTemplate.update("DELETE FROM region WHERE id=?", regionx.getId());
	}
	//all Entrenadores
	public List<Entrenador> findAllEntrenadores(){
		return jdbcTemplate.query("SELECT * FROM entrenador", new EntrenadorRowMapper() );
	}
	public void  updateActiveEntrenadorTrue(Integer id) {
		 jdbcTemplate.update("UPDATE entrenador SET active = true WHERE id = ?", id );
	}
}
