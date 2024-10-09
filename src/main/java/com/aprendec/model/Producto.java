package com.aprendec.model;

import java.sql.Timestamp;

/**
 * Clase que representa un producto en el sistema.
 * Contiene atributos que describen las propiedades de un producto
 * y métodos para acceder y modificar esos atributos.
 */
public class Producto {

	private int id;
	private String nombre;
	private double cantidad;
	private double precio;
	private Timestamp fechaCrear;
	private Timestamp fechaActualizar;

    /**
     * Constructor que inicializa un nuevo objeto Producto con los valores dados.
     * 
     * @param id            El identificador del producto.
     * @param nombre        El nombre del producto.
     * @param cantidad      La cantidad disponible del producto.
     * @param precio        El precio del producto.
     * @param fechaCrear    La fecha de creación del producto.
     * @param fechaActualizar La fecha de la última actualización del producto.
     */
	public Producto(int id, String nombre, double cantidad, double precio, Timestamp fechaCrear, Timestamp fechaActualizar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCrear = fechaCrear;
		this.fechaActualizar = fechaActualizar;
	}
    /**
     * Constructor por defecto para crear un objeto Producto sin inicializar.
     */
	public Producto() {
		// TODO Auto-generated constructor stub
	}

    /**
     * Obtiene el identificador del producto. (id)
     * 
     * @return El identificador del producto. (id)
     */
	public int getId() {
		return id;
	}

    /**
     * Establece el identificador del producto. (id)
     * 
     * @param id El nuevo identificador del producto. (id)
     */
	public void setId(int id) {
		this.id = id;
	}

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
	public String getNombre() {
		return nombre;
	}

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nuevo nombre del producto.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     * Obtiene la cantidad disponible del producto.
     * 
     * @return La cantidad del producto.
     */
	public double getCantidad() {
		return cantidad;
	}

    /**
     * Establece la cantidad disponible del producto.
     * 
     * @param cantidad La nueva cantidad del producto.
     */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
	public double getPrecio() {
		return precio;
	}

    /**
     * Establece el precio del producto.
     * 
     * @param precio El nuevo precio del producto.
     */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

    /**
     * Obtiene la fecha de creación del producto.
     * 
     * @return La fecha de creación del producto.
     */
	public Timestamp getFechaCrear() {
		return fechaCrear;
	}

    /**
     * Establece la fecha de creación del producto.
     * 
     * @param fechaCrear La nueva fecha de creación del producto.
     */
	public void setFechaCrear(Timestamp fechaCrear) {
		this.fechaCrear = fechaCrear;
	}

    /**
     * Obtiene la fecha de la última actualización del producto.
     * 
     * @return La fecha de actualización del producto.
     */
	public Timestamp getFechaActualizar() {
		return fechaActualizar;
	}

    /**
     * Establece la fecha de la última actualización del producto.
     * 
     * @param fechaActualizar La nueva fecha de actualización del producto.
     */
	public void setFechaActualizar(Timestamp fechaActualizar) {
		this.fechaActualizar = fechaActualizar;
	}

    /**
     * Representación en forma de cadena del objeto Producto.
     * 
     * @return Una cadena que representa el producto.
     */
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fechaCrear=" + fechaCrear + ", fechaActualizar=" + fechaActualizar + "]";
	}

}
