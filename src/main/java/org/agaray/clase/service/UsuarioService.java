package org.agaray.clase.service;

import org.agaray.clase.entity.Usuario;
import org.agaray.clase.repository.AlumnoRepository;
import org.agaray.clase.repository.ProfesorRepository;
import org.agaray.clase.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private ProfesorRepository profesorRepository;
	
	
	public void login(String dni, String pwd, String nombreLogin, String pwdLogin) {
		Usuario usuario = null;
		
		/*
		if (new BCryptPasswordEncoder().matches(pwd, usuario.getPwd())) {
			s.setAttribute("persona", usuario);
		} else {
			returnLocation = "redirect:/errorDisplay?msg=Password incorrecta";
		}
		*/

	}

}
