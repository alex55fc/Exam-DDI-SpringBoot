package com.example.examenSpringAlexFuela.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PokemonRowMapper implements RowMapper<Pokemon> {

	@Override
	public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pokemon pokemon = new Pokemon();
		pokemon.setId(rs.getInt("id"));
		pokemon.setNombre(rs.getString("nombre"));
		
		int regionId = rs.getInt("region");
		int entrenadorId = rs.getInt("entrenador_id");
		Region regionx = new Region();
		Entrenador entrenadorx = new Entrenador();
		regionx.setId(regionId);
		entrenadorx.setId(entrenadorId);
		
		pokemon.setRegion(regionx);
		pokemon.setEntrenador(entrenadorx);
		
		return pokemon;
	}

}
