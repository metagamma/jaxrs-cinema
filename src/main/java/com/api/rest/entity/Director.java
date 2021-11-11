package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Director")

public class Director implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Director_id")
	private Long director_id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellido")
	private String apellido;

	@OneToMany(mappedBy = "DirectorPelicula")
	private List<Film> listaPelicula;

	// GETTERS & SETTERS

	public Long getDirector_id() {
		return director_id;
	}

	public void setDirector_id(Long director_id) {
		this.director_id = director_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
