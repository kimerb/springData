package com.venta.servicios;

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

public interface ServicioVenta {

	ProductoRepository getRepoproducto();
	void setRepoproducto(ProductoRepository repoproducto);
	Producto findOneProd(Integer id);
	Iterable<Producto> findAllProd();
	void saveProd(Producto producto);
	void deleteProd(Producto producto);

	CategoriaRepository getRepocategoria();
	void setRepocategoria(CategoriaRepository repocategoria);
	Categoria findOneCat(Integer id);
	Iterable<Categoria> findAllCat();
	void saveCat(Categoria categoria);
	void deleteCat(Categoria categoria);
	/********eblas**********/
	DocumentoRepository getRepodocumento();
	void setRepodocumento(DocumentoRepository repodocumento);
	Documento findOneDoc(Integer id);
	Iterable<Documento> findAllDoc();
	void saveDoc(Documento documento);
	void deleteDoc(Documento documento);
	
	// find by nombre
	Iterable<Producto> findByNombre(String repocliente);
	
	/********eblas**********/
	ClienteRepository getRepocliente();
	void setRepocliente(ClienteRepository repocliente);
	Cliente findOneClie(Integer id);
	Iterable<Cliente> findAllClie();
	void saveClie(Cliente cliente);
	void deleteClie(Cliente cliente);
	
	FacturaRepository getRepofactura();
	void setRepofactura(FacturaRepository repofactura);
	Factura findOneFact(Integer id);
	Iterable<Factura> findAllFact();
	void saveFact(Factura factura);
	void deleteFact(Factura factura);
	
	DetalleRepository getRepodetalle();
	void setRepodetalle(DetalleRepository repodetalle);
	Detalle findOneDet(Integer id);
	Iterable<Detalle> findAllDet();
	void saveDet(Detalle detalle);
	void deleteDet(Detalle detalle);
	
}