package org.agaray.clase.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nombre;

	@OneToMany(mappedBy = "asignatura")
	private Collection<Nota> notas;

	@ManyToOne(cascade = CascadeType.ALL)
	private Profesor profesor;

	@JsonIgnore
	@ManyToMany(mappedBy = "asignaturas")
	private Collection<Alumno> alumnos;
	// ==============================
	public Asignatura() {
		this.notas =new ArrayList<Nota>();
		this.alumnos =new ArrayList<Alumno>();
	}
	
	public Asignatura(String nombre) {
		this.nombre = nombre;
		this.notas =new ArrayList<Nota>();
		this.alumnos =new ArrayList<Alumno>();
	}

	// ==============================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Nota> notas) {
		this.notas = notas;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Collection<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Collection<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	
	// ==============================

	// ==============================
	public void addProfesor(Profesor profesor) {
		this.profesor = profesor;
		profesor.getAsignaturas().add(this);
	}
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
		alumno.getAsignaturas().add(this);
	}


}
