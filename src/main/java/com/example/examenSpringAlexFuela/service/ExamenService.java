package com.example.examenSpringAlexFuela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
