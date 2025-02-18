package com.proyecto.pablo.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.proyecto.pablo.modelos.LoginUsuario;
import com.proyecto.pablo.modelos.Usuario;
import com.proyecto.pablo.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		String password = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!password.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Password y Confirmación deben ser iguales");
		}
		
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repoUsuarios.findByEmail(email);
		if (existeUsuario != null) {
			result.rejectValue("email", "Unique", "E-mail ya se encuentra registrado. prueba con otro.");
		}
		
		if (result.hasErrors()) {
			return null;
		} else {
			String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt());
			nuevoUsuario.setPassword(passwordHasheado);
			return repoUsuarios.save(nuevoUsuario);
		}
	}
	
	public Usuario login(LoginUsuario datosInicioDeSesion, BindingResult result) {
		String email = datosInicioDeSesion.getEmailLogin();
		Usuario existeUsuario = repoUsuarios.findByEmail(email);
		if (existeUsuario == null) {
			result.rejectValue("emailLogin","Unique","E-mail no registrado");
		} else {
			if(! BCrypt.checkpw(datosInicioDeSesion.getPasswordLogin(), existeUsuario.getPassword())) {
				// NO COINCIDEN
				result.rejectValue("passwordLogin","Matches","Contraseña Incorrecta ... ");
			}
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return existeUsuario;
		}
	}

}
