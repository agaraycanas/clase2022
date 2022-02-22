package org.agaray.clase.controller;

import javax.servlet.http.HttpSession;

import org.agaray.clase.entity.Profesor;
import org.agaray.clase.entity.Usuario;
import org.agaray.clase.exception.DangerException;
import org.agaray.clase.exception.PRG;
import org.agaray.clase.helper.H;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nota")
public class NotaController {
	
	@GetMapping("r")
	public String r(
			ModelMap m,
			HttpSession s) throws DangerException {
		String vista = "";
		Usuario usuario = null;
		if (s.getAttribute("usuario")!=null) {
			usuario = (Usuario)s.getAttribute("usuario");
			if (usuario.getRol().equals("alumno")) {
				vista = "nota/rAlumno";
			}
			else if (usuario.getRol().equals("profesor")) {
				vista = "nota/rProfesor";
			}
		}
		if (usuario == null || usuario.getRol().equals("DESCONOCIDO")) {
			PRG.error("Rol incorrecto");
		}
		m.put("view", vista);
		return "_t/frame";
	}
	
	@GetMapping("c")
	public String c(
			ModelMap m,
			HttpSession s
			) throws DangerException {
		H.isRolOK("profesor", s);
		m.put("asignaturas", ((Profesor)s.getAttribute("usuario")).getAsignaturas());
		m.put("view", "nota/c01IntroAsig");
		return "_t/frame";
	}
	
	@PostMapping("c")
	public String cPost() {
		return "redirect:/nota/r";
	}
}
