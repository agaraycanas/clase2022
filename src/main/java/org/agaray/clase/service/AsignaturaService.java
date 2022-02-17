package org.agaray.clase.service;


import java.util.List;

import org.agaray.clase.entity.Asignatura;
import org.agaray.clase.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	public void crearAsignatura(String nombre) throws Exception {
		Asignatura asignatura = new Asignatura(nombre);
		try {
			asignaturaRepository.save(asignatura);
		}
		catch (Exception e) {
			throw new Exception("La asignatura "+nombre+" ya existe");
		}
	}

	public List<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}
}
