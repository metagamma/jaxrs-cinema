package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sede")

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Sede_id")
	private Long sede_id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Telefono")
	private String telefono;

	@Column(name = "Capacidad")
	private int capacidad;

	@OneToMany(mappedBy = "SedePelicula")
	private List<Film> listaPelicula;

	@OneToMany(mappedBy = "SedeEmpleado")
	private List<Employee> listaEmpleado;

	@OneToMany(mappedBy = "SedeFuncion")
	private List<Showtime> listaFuncion;

	// GETTERS & SETTERS

	public Long getSede_id() {
		return sede_id;
	}

	public void setSede_id(Long sede_id) {
		this.sede_id = sede_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
