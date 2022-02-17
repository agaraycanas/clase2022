package org.agaray.clase.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Profesor extends Usuario {
	
	
	@OneToMany(mappedBy = "profesor")
	private Collection<Asignatura> asignaturas;
	
	//==========================

	public Profesor(String dni, String nombre, String apellido, String password) {
		super(dni,nombre,apellido,password);
		this.asignaturas = new ArrayList<>();
	}
	public Profesor() {
		this.asignaturas = new ArrayList<>();
	}
	//==========================
	public Collection<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Collection<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	
}
