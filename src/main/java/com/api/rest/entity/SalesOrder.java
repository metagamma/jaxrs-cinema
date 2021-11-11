package com.api.rest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "OrdenVenta")

public class SalesOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "OrdenVenta_id")
	private Long orden_venta_id;

	@Column(name = "CodigoReserva")
	private String codigo_reserva;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private Customer ClienteOrdenVenta;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Empleado_id")
	private Employee EmpleadoOrdenVenta;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Funcion_id")
	private Showtime FuncionOrdenVenta;

	@Column(name = "Asiento")
	private int asiento;

	@Column(name = "Fila")
	private String fila;

	@Column(name = "Cantidad")
	private int cantidad;

	@Column(name = "Monto")
	private double monto;

	// GETTERS & SETTERS

	public Long getOrden_venta_id() {
		return orden_venta_id;
	}

	public void setOrden_venta_id(Long orden_venta_id) {
		this.orden_venta_id = orden_venta_id;
	}

	public String getCodigo_reserva() {
		return codigo_reserva;
	}

	public void setCodigo_reserva(String codigo_reserva) {
		this.codigo_reserva = codigo_reserva;
	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Customer getClienteOrdenVenta() {
		return ClienteOrdenVenta;
	}

	public void setClienteOrdenVenta(Customer clienteOrdenVenta) {
		ClienteOrdenVenta = clienteOrdenVenta;
	}

	public Employee getEmpleadoOrdenVenta() {
		return EmpleadoOrdenVenta;
	}

	public void setEmpleadoOrdenVenta(Employee empleadoOrdenVenta) {
		EmpleadoOrdenVenta = empleadoOrdenVenta;
	}

	public Showtime getFuncionOrdenVenta() {
		return FuncionOrdenVenta;
	}

	public void setFuncionOrdenVenta(Showtime funcionOrdenVenta) {
		FuncionOrdenVenta = funcionOrdenVenta;
	}

}
