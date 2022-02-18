package org.agaray.clase.controller;

import java.util.List;

import org.agaray.clase.exception.DangerException;
import org.agaray.clase.exception.PRG;
import org.agaray.clase.service.AlumnoService;
import org.agaray.clase.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AsignaturaService asignaturaService;

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("c")
	public String c(ModelMap m) {
		m.put("asignaturas", asignaturaService.findAll());
		m.put("view", "alumno/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(
			@RequestParam("dni") String dni, @RequestParam("password") String password,
			@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
			@RequestParam(value = "idAsignatura[]", required = false) List<Long> idsAsignatura) throws DangerException {
		try {
			alumnoService.crearAlumno(dni, password, nombre, apellido, idsAsignatura);
		} catch (Exception e) {
			PRG.error(e.getMessage(),"/alumno/c");
		}
		return "redirect:/alumno/r";
	}

	@GetMapping("r")
	public String r(ModelMap m) {
		m.put("alumnos",alumnoService.findAll());
		m.put("view", "alumno/r");
		return "_t/frame";
	}
}
