package com.aprendec.model;

import java.sql.Timestamp;

public class Producto {

	private int id;
	private String nombre;
	private double cantidad;
	private double precio;
	private Timestamp fechaCrear;
	private Timestamp fechaActualizar;

	public Producto(int id, String nombre, double cantidad, double precio, Timestamp fechaCrear, Timestamp fechaActualizar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCrear = fechaCrear;
		this.fechaActualizar = fechaActualizar;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Timestamp getFechaCrear() {
		return fechaCrear;
	}

	public void setFechaCrear(Timestamp fechaCrear) {
		this.fechaCrear = fechaCrear;
	}

	public Timestamp getFechaActualizar() {
		return fechaActualizar;
	}

	public void setFechaActualizar(Timestamp fechaActualizar) {
		this.fechaActualizar = fechaActualizar;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fechaCrear=" + fechaCrear + ", fechaActualizar=" + fechaActualizar + "]";
	}

}
