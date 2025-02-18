package com.proyecto.pablo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.pablo.modelos.Serie;
import com.proyecto.pablo.modelos.Usuario;
import com.proyecto.pablo.servicios.ServicioSeries;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {
	
	//Servicios
	@Autowired
	private ServicioSeries servSeries;
	
	@GetMapping("/dashboard2")
	public String dashboard(HttpSession session,
							Model model /*Enviar información del método al JSP*/ ) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		//Generar la lista con las pelis
		List<Serie> series = servSeries.todasLasSeries();
		
		//Enviar esa lista a dashboard
		model.addAttribute("series", series);
		
		return "dashboard2.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("nuevaSerie") Serie nuevaSerie, HttpSession session) {
		if (session.getAttribute("usuarioEnSesion") == null) {
			return "redirect:/";
		}
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("nuevaSerie") Serie nuevaSerie,
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		
		} else {
			servSeries.guardarSerie(nuevaSerie);
			return "redirect:/dashboard2";
		}
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,
						 @ModelAttribute("pelicula") Serie serie,
						 Model model,
						 HttpSession session) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Serie serieAEditar = servSeries.buscarSerie(id);
		
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioEnSesion.getId() !=  serieAEditar.getCreador().getId()) {
			return "redirect:/dashboard";
		}
		
		
		model.addAttribute("serie", serieAEditar);
		
		return "editar.jsp";
		
	}

	@PutMapping("/actualizar/{id}") 
	public String actualizar(@Valid @ModelAttribute("pelicula") Serie serie, BindingResult result) {
		
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			servSeries.guardarSerie(serie);
			return "redirect:/dashboard2";
		}	
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") Long id) {
		servSeries.borrarSerie(id);
		return "redirect:/dashboard2";
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id") Long id,
						  Model model,
						  HttpSession session) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Serie serie = servSeries.buscarSerie(id);
		model.addAttribute("serie", serie); 
		
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
		Usuario usuario = servSeries.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "mostrar.jsp";
		
	}
	
	@GetMapping("/agregarFavoritos/{usuarioId}/{peliculaId}")
	public String agregarFavoritos(@PathVariable("usuarioId") Long usuarioId,
								   @PathVariable("serieId") Long serieId,
								   HttpSession session) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		servSeries.guardarSerieFavorita(usuarioId, serieId);
		
		return "redirect:/mostrar/"+serieId;
	}
	
	@GetMapping("/quitarFavoritos/{usuarioId}/{peliculaId}")
	public String quitarFavoritos(@PathVariable("usuarioId") Long usuarioId,
								   @PathVariable("serieId") Long serieId,
								   HttpSession session) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		servSeries.quitarSerieFavorita(usuarioId, serieId);
		
		return "redirect:/mostrar/"+serieId;
	}
	
	@GetMapping("/favoritos")
	public String favoritos(HttpSession session, Model model) {
		if(session.getAttribute("usuarioEnSesion") == null) {
			return "redirect:/";
		}
		
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
		Usuario usuario = servSeries.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "favoritos.jsp";
	}
	
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam(value="palabra")String palabra, HttpSession session, Model model) {
		if(session.getAttribute("usuarioEnSesion") == null) {
			return "redirect:/";
		}
		List<Serie> series = servSeries.buscarSerieConPalabra(palabra);
		model.addAttribute("series", series);
		return "dashboard2.jsp";
	}
	

}
