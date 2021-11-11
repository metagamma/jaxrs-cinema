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
@Table(name = "Pelicula")

public class Film implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Pelicula_id")
	private Long pelicula_id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Imagen")
	private String imagen;

	@Column(name = "Sinopsis")
	private String sinopsis;

	@Column(name = "Duracion")
	private int duracion;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Director_id")
	private Director DirectorPelicula;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Clasificacion_id")
	private Rating ClasificacionPelicula;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Genero_id")
	private Genre GeneroPelicula;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Formato_id")
	private Format FormatoPelicula;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Sede_id")
	private Location SedePelicula;

	@OneToMany(mappedBy = "PeliculaFuncion")
	private List<Showtime> listaFuncion;

	// GETTERS & SETTERS

	public Long getPelicula_id() {
		return pelicula_id;
	}

	public void setPelicula_id(Long pelicula_id) {
		this.pelicula_id = pelicula_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Director getDirectorPelicula() {
		return DirectorPelicula;
	}

	public void setDirectorPelicula(Director directorPelicula) {
		DirectorPelicula = directorPelicula;
	}

	public Genre getGeneroPelicula() {
		return GeneroPelicula;
	}

	public void setGeneroPelicula(Genre generoPelicula) {
		GeneroPelicula = generoPelicula;
	}

	public Format getFormatoPelicula() {
		return FormatoPelicula;
	}

	public void setFormatoPelicula(Format formatoPelicula) {
		FormatoPelicula = formatoPelicula;
	}

	public Rating getClasificacionPelicula() {
		return ClasificacionPelicula;
	}

	public void setClasificacionPelicula(Rating clasificacionPelicula) {
		ClasificacionPelicula = clasificacionPelicula;
	}

	public Location getSedePelicula() {
		return SedePelicula;
	}

	public void setSedePelicula(Location sedePelicula) {
		SedePelicula = sedePelicula;
	}

}
