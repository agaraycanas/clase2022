package org.agaray.clase.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Profesor extends Usuario {
	
	
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
	private Collection<Asignatura> asignaturas;
	
	//==========================

	public Profesor(String dni, String password, String nombre, String apellido) {
		super(dni,password,nombre,apellido);
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
