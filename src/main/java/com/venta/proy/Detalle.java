package com.venta.proy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="detalle")
public class Detalle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(min=0)
	private double precio;
	
	@Size(min=1)
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="producto_id")
	private Producto producto;

	public Detalle() {
		super();
	}

	public Detalle(int id) {
		super();
		this.id = id;
	}

	public Detalle(@Size(min = 0) double precio, @Size(min = 1) int cantidad, Producto producto) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}