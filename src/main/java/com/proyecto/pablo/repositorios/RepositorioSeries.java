package com.proyecto.pablo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.pablo.modelos.Serie;

@Repository
public interface RepositorioSeries extends CrudRepository<Serie, Long> {
	List<Serie> findAll();
	
	List<Serie> findAllByOrderByTituloAsc();
	
	List<Serie> findAllByOrderByTituloDesc();
	
	List<Serie> findByTituloContaining(String palabra);

}
