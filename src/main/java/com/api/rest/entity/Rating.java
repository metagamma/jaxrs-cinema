package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clasificacion")

public class Rating implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Clasificacion_id")
	private Long clasificacion_id;

	@Column(name = "Nombre")
	private String nombre;

	@OneToMany(mappedBy = "ClasificacionPelicula")
	private List<Film> listaPelicula;

	// GETTERS & SETTERS

	public Long getClasificacion_id() {
		return clasificacion_id;
	}

	public void setClasificacion_id(Long clasificacion_id) {
		this.clasificacion_id = clasificacion_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
