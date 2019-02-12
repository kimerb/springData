package com.venta.servicios.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.venta.proy.Categoria;
import com.venta.proy.Cliente;
import com.venta.proy.Detalle;
import com.venta.proy.Documento;
import com.venta.proy.Factura;
import com.venta.proy.Producto;
import com.venta.repositorios.CategoriaRepository;
import com.venta.repositorios.ClienteRepository;
import com.venta.repositorios.DetalleRepository;
import com.venta.repositorios.DocumentoRepository;
import com.venta.repositorios.FacturaRepository;
import com.venta.repositorios.ProductoRepository;
import com.venta.servicios.ServicioVenta;

@Service
public class ServicioVentaJPA implements ServicioVenta {
	@Autowired
	private ProductoRepository repoproducto;
	@Autowired
	private CategoriaRepository repocategoria;
	@Autowired
	private DocumentoRepository repodocumento;
	@Autowired
	private ClienteRepository repocliente;
	@Autowired
	private FacturaRepository repofactura;
	@Autowired
	private DetalleRepository repodetalle;

	
	public ProductoRepository getRepoproducto() {
		return repoproducto;
	}
	public void setRepoproducto(ProductoRepository repoproducto) {
		this.repoproducto = repoproducto;
	}

	public CategoriaRepository getRepocategoria() {
		return repocategoria;
	}
	public void setRepocategoria(CategoriaRepository repocategoria) {
		this.repocategoria = repocategoria;
	}
	
	public DocumentoRepository getRepodocumento() {
		return repodocumento;
	}
	public void setRepodocumento(DocumentoRepository repodocumento) {
		this.repodocumento = repodocumento;
	}
	
	public ClienteRepository getRepocliente() {
		return repocliente;
	}
	public void setRepocliente(ClienteRepository repocliente) {
		this.repocliente = repocliente;
	}
	
	public FacturaRepository getRepofactura() {
		return repofactura;
	}
	public void setRepofactura(FacturaRepository repofactura) {
		this.repofactura = repofactura;
	}
	
	public DetalleRepository getRepodetalle() {
		return repodetalle;
	}
	public void setRepodetalle(DetalleRepository repodetalle) {
		this.repodetalle = repodetalle;
	}
	
	public Producto findOneProd(Integer id) {
		return repoproducto.findOne(id);
	}
	
	public Iterable<Producto> findAllProd() {
		return repoproducto.findAll();
	}

	@Transactional
	public void saveProd(Producto producto) {
		repoproducto.save(producto);
	}

	 @Transactional
	public void deleteProd(Producto producto) {
		repoproducto.delete(producto);
	}

	public Categoria findOneCat(Integer id) {
		return repocategoria.findOne(id);
	}
	
	public Iterable<Categoria> findAllCat() {
		return repocategoria.findAll();
	}

	@Transactional
	public void saveCat(Categoria categoria) {
		repocategoria.save(categoria);
	}
	
	@Transactional
	public void deleteCat(Categoria categoria) {
		repocategoria.delete(categoria);
	}
	/****************/
	public Documento findOneDoc(Integer id) {
		return repodocumento.findOne(id);
	}
	
	public Iterable<Documento> findAllDoc() {
		return repodocumento.findAll();
	}

	@Transactional
	public void saveDoc(Documento documento) {
		repodocumento.save(documento);
	}
	
	@Transactional
	public void deleteDoc(Documento documento) {
		repodocumento.delete(documento);
	}
	
	@Override
	public Iterable<Producto> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repoproducto.findByNombre(nombre);
	}
	/********eblas**********/
	public Cliente findOneClie(Integer id) {
		return repocliente.findOne(id);
	}
	
	public Iterable<Cliente> findAllClie() {
		return repocliente.findAll();
	}

	@Transactional
	public void saveClie(Cliente cliente) {
		repocliente.save(cliente);
	}
	
	@Transactional
	public void deleteClie(Cliente cliente) {
		repocliente.delete(cliente);
	}
	
	/********eblas**********/
	public Factura findOneFact(Integer id) {
		return repofactura.findOne(id);
	}
	
	public Iterable<Factura> findAllFact() {
		return repofactura.findAll();
	}
	
	@Transactional
	public void saveFact(Factura factura) {
		repofactura.save(factura);
	}
	
	@Transactional
	public void deleteFact(Factura factura) {
		repofactura.delete(factura);
	}
	
	/********eblas**********/
	public Detalle findOneDet(Integer id) {
		return repodetalle.findOne(id);
	}
	
	public Iterable<Detalle> findAllDet() {
		return repodetalle.findAll();
	}
	
	@Transactional
	public void saveDet(Detalle detalle) {
		repodetalle.save(detalle);
	}
	
	@Transactional
	public void deleteDet(Detalle detalle) {
		repodetalle.delete(detalle);
	}
}
