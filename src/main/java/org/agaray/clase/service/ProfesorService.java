package org.agaray.clase.service;

import java.util.List;

import org.agaray.clase.entity.Asignatura;
import org.agaray.clase.entity.Profesor;
import org.agaray.clase.repository.AsignaturaRepository;
import org.agaray.clase.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	public void crearProfesor(String dni, String password, String nombre, String apellido, List<Long> idAsignatura)
			throws Exception {
		Profesor profesor = new Profesor(dni,password,nombre,apellido);
		for (Long id: idAsignatura) {
			Asignatura asignatura = asignaturaRepository.getById(id);
			if (asignatura.getProfesor()!=null) {
				throw new Exception("La asignatura "+ asignatura.getNombre() + " ya está siendo impartida por otro profesor");
			}
			asignatura.addProfesor(profesor);
		}
		profesorRepository.save(profesor);
	}
	
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}
}
