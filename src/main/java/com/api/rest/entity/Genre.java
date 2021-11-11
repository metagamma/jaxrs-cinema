package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Genero")

public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Genero_id")
	private Long genero_id;

	@Column(name = "Nombre")
	private String nombre;

	@OneToMany(mappedBy = "GeneroPelicula")
	private List<Film> listaPelicula;

	// GETTERS & SETTERS

	public Long getGenero_id() {
		return genero_id;
	}

	public void setGenero_id(Long genero_id) {
		this.genero_id = genero_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
