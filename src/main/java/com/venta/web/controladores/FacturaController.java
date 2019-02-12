package com.venta.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.venta.proy.Factura;
import com.venta.proy.Producto;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	@Autowired
	ServicioVenta servicio;

	@RequestMapping("/index")
	public String lista(Model modelo) {
		modelo.addAttribute("facturas", servicio.findAllFact());
		return "factura/fact-index";
	}
	
	@RequestMapping("/new")
	public String fNuevaFactura(Model modelo) {
		modelo.addAttribute(new Factura());
		modelo.addAttribute("clientes", servicio.findAllClie());
		modelo.addAttribute("documentos", servicio.findAllDoc());
		return "factura/fact-new";
	}
	
	@RequestMapping(value="/insertarFactura",method=RequestMethod.POST)
	public String insertarFactura(@Valid @ModelAttribute Factura factura, BindingResult validacion, Model modelo) {
		if(validacion.hasErrors()){
			System.out.println("2222222222222222");
			System.out.println(validacion.getAllErrors());
			System.out.println("3333333333333333");
			return "factura/fact-new";
		}else{
			servicio.saveFact(factura);
			modelo.addAttribute("facturas", servicio.findAllFact());
			return "factura/fact-index";
		}
	}

	@RequestMapping("/edit")
	public String editarFactura(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("factura", servicio.findOneFact(id));
		modelo.addAttribute("documentos", servicio.findAllDoc());
		modelo.addAttribute("clientes", servicio.findAllClie());
		return "factura/fact-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String modificarFactura(@Valid @ModelAttribute Factura factura, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			System.out.println("2222222222222222*");
			System.out.println(validacion.getAllErrors());
			System.out.println("*3333333333333333");
			return "factura/fact-edit";
		} else {
			Factura f = servicio.findOneFact(factura.getId());
			f.setNumero(factura.getNumero());
			f.setFecha(factura.getFecha());
			f.setDocumento(factura.getDocumento());
			f.setCliente(factura.getCliente());
			servicio.saveFact(factura);
			modelo.addAttribute("facturas", servicio.findAllFact());
			return "factura/fact-index";
		}
	}
	
	@RequestMapping("/borrarFactura")
	public String borrarFactura(@RequestParam("clave") Integer id, Model modelo) {
		servicio.deleteFact(new Factura(id));
		modelo.addAttribute("facturas", servicio.findAllFact());
		return "factura/fact-index";
	}
}