package com.example.examenSpringAlexFuela.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EntrenadorRowMapper implements RowMapper<Entrenador> {

	@Override
	public Entrenador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Entrenador entrenador = new Entrenador();
		entrenador.setId(rs.getInt("id"));
		entrenador.setNombre(rs.getString("nombre"));
		entrenador.setActive(rs.getBoolean("active"));
		
		return entrenador;
	}

}
