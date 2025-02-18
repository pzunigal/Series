package com.proyecto.pablo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.pablo.modelos.Serie;
import com.proyecto.pablo.modelos.Usuario;
import com.proyecto.pablo.repositorios.RepositorioSeries;
import com.proyecto.pablo.repositorios.RepositorioUsuarios;

@Service
public class ServicioSeries {
	
	@Autowired
	private RepositorioSeries repoSeries;
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public List<Serie> todasLasSeries() {
		return repoSeries.findAllByOrderByTituloAsc();
	}
	
	public Serie guardarSerie(Serie serie) {
		return repoSeries.save(serie);
	}
	
	public Serie buscarSerie(Long id) {
		return repoSeries.findById(id).orElse(null);
	}
	
	public void borrarSerie(Long id) {
		repoSeries.deleteById(id);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void guardarSerieFavorita(Long usuarioId, Long serieId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		Serie miSerie = buscarSerie(serieId);
		
		miUsuario.getSeriesFavoritas().remove(miSerie);
		repoUsuarios.save(miUsuario);
	}
	
	public void quitarSerieFavorita(Long usuarioId, Long serieId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Serie miSerie = buscarSerie(serieId);
		
		miUsuario.getSeriesFavoritas().remove(miSerie);
		repoUsuarios.save(miUsuario);
	}
	
	public List<Serie> buscarSerieConPalabra(String palabra) {
		return repoSeries.findByTituloContaining(palabra);
	}
	
	

}
