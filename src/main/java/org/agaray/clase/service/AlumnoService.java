package org.agaray.clase.service;

import java.util.List;

import org.agaray.clase.entity.Alumno;
import org.agaray.clase.entity.Asignatura;
import org.agaray.clase.repository.AlumnoRepository;
import org.agaray.clase.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	public void crearAlumno(String dni, String password, String nombre, String apellido, List<Long> idsAsignatura)
			throws Exception {
		Alumno alumno = new Alumno(dni, password, nombre, apellido);
		if (idsAsignatura != null) {
			for (Long idAsignatura : idsAsignatura) {
				Asignatura asignatura = asignaturaRepository.getById(idAsignatura);
				asignatura.addAlumno(alumno);
			}
		}
		alumnoRepository.save(alumno);
	}

	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

}
