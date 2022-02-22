package org.agaray.clase.repository;

import java.util.List;

import org.agaray.clase.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
 	public List<Alumno> findByApellidoOrderByNombre(String apellido);
	public List<Alumno> findByAsignaturasNombre(String nombreAsignatura);
}
