package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Formato")

public class Format implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Formato_id")
	private Long formato_id;

	@Column(name = "Nombre")
	private String Nombre;

	@OneToMany(mappedBy = "FormatoPelicula")
	private List<Film> listaPelicula;

	// GETTERS & SETTERS

	public Long getFormato_id() {
		return formato_id;
	}

	public void setFormato_id(Long formato_id) {
		this.formato_id = formato_id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

}
