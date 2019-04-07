package com.bolsadeideas.springboot.datajpa.app.controllers;

import com.bolsadeideas.springboot.datajpa.app.model.entity.Cliente;

import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.datajpa.app.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by hmartinez on 4/3/2019.
 */
@Controller
@SessionAttributes("Cliente")  // Cada vez que se invoque a un metodo GET (crear o modificar) se almacenara a Cliente
                               // en la sesion y lo pasara a la vista hasta que se envie al metodo guardar
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }

	/**
	 * Este metodo crear el formulario para que se ingresen los datos del cliente
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente",cliente);
		model.put("Titulo", "Formulario de Cliente");
		return "form";
	}

	@RequestMapping(value = "form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String,Object> model){
		Cliente cliente = null;
		if (id > 0){
			cliente = clienteService.findOne(id);
			model.put("cliente", cliente);
		} else {
			return "redirect:/listar";
		}
		model.put("Titulo","Editar cliente");
		return "form";
	}
	
	/**
	 * Este metodo recive los datos de la ventana de registro de cliente 
	 * y lo envia al metodo de la DAO para hacer el respectivo regsitro
	 * en la BD.
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		model.addAttribute("Titulo", "Formulario de Cliente");
		if(result.hasErrors()) {
			return "form";
		}
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id){
	    if(id != null && id > 0){
	        clienteService.delete(id);
        }
        return "redirect:/listar";
    }
}
