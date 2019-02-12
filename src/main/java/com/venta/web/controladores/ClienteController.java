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
import com.venta.proy.Cliente;
import com.venta.servicios.ServicioVenta;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	ServicioVenta servicio;

	@RequestMapping("/index")
	public String lista(Model modelo) {
		// Envia a la vista es decir a la plantilla todos los clientes
		modelo.addAttribute("clientes", servicio.findAllClie());
		// clie-index.html en la carpeta cliente
		return "cliente/clie-index";
	}

	@RequestMapping("/new")
	public String fNuevocliente(Model modelo) {
		//Enviamos un objeto cliente en blanco para ser llenado y persistido 
		modelo.addAttribute(new Cliente());
		return "cliente/clie-new";
	}

	// ya tenemos el cliente rellenado con los datos del formulario
	@RequestMapping(value = "/insertarCliente", method = RequestMethod.POST)
	public String insertarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "cliente/clie-new";
		} else {
			servicio.saveClie(cliente);
			modelo.addAttribute("clientes", servicio.findAllClie());
			return "cliente/clie-index";
		}
	}

	@RequestMapping("/borrarCliente")
	public String borrarCliente(@RequestParam("clave") Integer id, Model modelo) {
		Cliente p = servicio.findOneClie(id);
		servicio.deleteClie(new Cliente(id));
		modelo.addAttribute("clientes", servicio.findAllClie());
		return "cliente/clie-index";
	}
	
	@RequestMapping("/edit")
	public String editarCliente(@RequestParam("clave") Integer id, Model modelo) {
		modelo.addAttribute("cliente", servicio.findOneClie(id));
		return "cliente/clie-edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String modificarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult validacion, Model modelo) {
		if (validacion.hasErrors()) {
			return "cliente/clie-edit";
		} else {
			servicio.saveClie(cliente);
			modelo.addAttribute("clientes", servicio.findAllClie());
			return "cliente/clie-index";
		}
	}
	
	
	@RequestMapping("/fCliedNombre")
	public String filtroClienteNombre(@RequestParam("nombre") String nombre,Model modelo) {
		modelo.addAttribute("clientes", servicio.findByNombre(nombre));
		return "cliente/clie-index";
	}
}