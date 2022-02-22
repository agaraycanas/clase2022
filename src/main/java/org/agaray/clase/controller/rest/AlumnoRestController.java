package org.agaray.clase.controller.rest;

import java.util.List;

import org.agaray.clase.entity.Alumno;
import org.agaray.clase.exception.DangerException;
import org.agaray.clase.exception.PRG;
import org.agaray.clase.repository.AlumnoRepository;
import org.agaray.clase.service.AlumnoService;
import org.agaray.clase.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/REST/alumno")
public class AlumnoRestController {

	@Autowired
	private AsignaturaService asignaturaService;

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("r")
	public List<Alumno> r() {
		return alumnoService.findAll();
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

}
