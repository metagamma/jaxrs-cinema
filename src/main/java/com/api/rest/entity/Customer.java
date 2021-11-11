package com.api.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Cliente_id")
	private Long cliente_id;

	@Column(name = "Dni")
	private String dni;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "ApellidoPaterno")
	private String apellido_paterno;

	@Column(name = "ApellidoMaterno")
	private String apellido_materno;

	@Column(name = "Fecha_nacimiento")
	private String fecha_nacimiento;

	@Column(name = "Correo")
	private String correo;

	@Column(name = "Tarjeta")
	private String tarjeta;

	@Column(name = "CVV")
	private String cvv;

	@OneToMany(mappedBy = "ClienteOrdenVenta")
	private List<SalesOrder> listaOrdenVenta;

	// GETTERS & SETTERS

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
