package com.venta.proy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="factura")
public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//@Size(min=1,max=9999999)
	private int numero;
	
	//@Temporal(TemporalType.DATE)
	//@Column(name = "fecha")
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	//@Column(nullable = false)
	//@NotNull
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name="documento_id")
	private Documento documento;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "factura", cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "factura_id")
	private List<Detalle> detalles = new ArrayList<Detalle>();

	public Factura() {
		super();
	}

	public Factura(int id) {
		super();
		this.id = id;
	}

	//public Factura(@Size(min = 1, max = 9999999) int numero, Date fecha, Cliente cliente, Documento documento, List<Detalle> detalles) {
	public Factura(int numero, Date fecha , Documento documento, Cliente cliente) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.documento = documento;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}