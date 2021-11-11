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
@Table(name = "Empleado")

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Empleado_id")
	private Long empleado_id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "ApellidoPaterno")
	private String apellido_paterno;

	@Column(name = "ApellidoMaterno")
	private String apellido_materno;

	@Column(name = "Usuario")
	private String usuario;

	@Column(name = "Clave")
	private String clave;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Sede_id")
	private Location SedeEmpleado;

	@OneToMany(mappedBy = "EmpleadoOrdenVenta")
	private List<SalesOrder> listaOrdenVenta;

	// GETTERS & SETTERS

	public Long getEmpleado_id() {
		return empleado_id;
	}

	public void setEmpleado_id(Long empleado_id) {
		this.empleado_id = empleado_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Location getSedeEmpleado() {
		return SedeEmpleado;
	}

	public void setSedeEmpleado(Location sedeEmpleado) {
		SedeEmpleado = sedeEmpleado;
	}

}
