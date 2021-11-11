package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Funcion")

public class Showtime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Funcion_id")
	private Long funcion_id;

	@Column(name = "FechaFuncion")
	private String fecha_funcion;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Pelicula_id")
	private Film PeliculaFuncion;

	@Column(name = "NumeroSala")
	private int numero_sala;

	@Column(name = "HoraInicio")
	private String hora_inicio;

	@Column(name = "HoraFin")
	private String hora_fin;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Sede_id")
	private Location SedeFuncion;

	@OneToMany(mappedBy = "FuncionOrdenVenta")
	private List<SalesOrder> listaOrdenVenta;

	// GETTERS & SETTERS

	public Long getFuncion_id() {
		return funcion_id;
	}

	public String getFecha_funcion() {
		return fecha_funcion;
	}

	public void setFecha_funcion(String fecha_funcion) {
		this.fecha_funcion = fecha_funcion;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public Location getSedeFuncion() {
		return SedeFuncion;
	}

	public void setSedeFuncion(Location sedeFuncion) {
		SedeFuncion = sedeFuncion;
	}

	public Film getPeliculaFuncion() {
		return PeliculaFuncion;
	}

	public void setPeliculaFuncion(Film peliculaFuncion) {
		PeliculaFuncion = peliculaFuncion;
	}

	public void setFuncion_id(Long funcion_id) {
		this.funcion_id = funcion_id;
	}

	public int getNumero_sala() {
		return numero_sala;
	}

	public void setNumero_sala(int numero_sala) {
		this.numero_sala = numero_sala;
	}

}
