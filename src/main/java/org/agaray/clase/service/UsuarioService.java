package org.agaray.clase.service;

import org.agaray.clase.entity.Usuario;
import org.agaray.clase.exception.DangerException;
import org.agaray.clase.exception.PRG;
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
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario login(String dni, String password) throws Exception {
		Usuario usuario=null;
		try {
			usuario = usuarioRepository.getByDni(dni);
		}
		catch (Exception e) {
			throw new Exception("Usuario incorrecto");
		}
		
		if (!(new BCryptPasswordEncoder().matches(password, usuario.getPassword()))) {
			throw new Exception("Contraseña incorrecta");
		}
		return usuario;
	}
}
