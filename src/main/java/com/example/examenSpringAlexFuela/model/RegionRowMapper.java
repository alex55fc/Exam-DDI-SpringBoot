package com.example.examenSpringAlexFuela.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RegionRowMapper implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
		Region region = new Region();
		region.setId(rs.getInt("id"));
		region.setNombre(rs.getString("nombre"));
		return region;
	}

}
