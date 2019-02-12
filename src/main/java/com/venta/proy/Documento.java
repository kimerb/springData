package com.venta.proy;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="documento")
public class Documento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//@Size(max=20)
	private String nombre;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "documento", cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Factura> facturas = new ArrayList<Factura>();

	public Documento(int id) {
		super();
		this.id = id;
	}

	public Documento(@Size(max = 20) String nombre) {
		super();
		this.nombre = nombre;
	}

	public Documento() {
		super();
	}
	
	public void addFactura(Factura f) {
		facturas.add(f);
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

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
