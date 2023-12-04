package com.example.examenSpringAlexFuela.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.examenSpringAlexFuela.model.Entrenador;
import com.example.examenSpringAlexFuela.model.Region;

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
}
