package unoesc.edu.euwash.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import unoesc.edu.euwash.model.Cliente;
import unoesc.edu.euwash.model.Servico;


@Controller
public class ClienteController {
	
	@RequestMapping(path = "/cliente", method = RequestMethod.GET)
	public String acessoServico(Model model, HttpSession session) {
		
		List<Cliente> clientes;
		if (session.getAttribute("listaCliente") == null) {
			clientes = new LinkedList<Cliente>();
			session.setAttribute("listaCliente", clientes);
		} else
			clientes = (LinkedList<Cliente>) session.getAttribute("listaCliente");
		
		model.addAttribute("listaCliente", clientes);
		model.addAttribute("cliente", new Cliente());
		
		return "ClienteView";
	}
	
	@RequestMapping(path = "/clienteSave", method = RequestMethod.POST)
	public String clienteSave(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
		List clientes = (LinkedList<Cliente>) session.getAttribute("listaCliente");
		
		if (cliente.getId() == 0) {
			clientes.add(cliente);
			cliente.setId(clientes.size());
			
		} else {
			Cliente c = (Cliente) clientes.get(cliente.getId() - 1);		
			c.setNome(cliente.getNome());
			c.setSobrenome(cliente.getSobrenome());
			c.setTelefone(cliente.getTelefone());
			c.setDataNasc(cliente.getDataNasc());
		}
		
		
		
		return "redirect:/cliente";
	}
	
	@RequestMapping(value = "/clienteEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		
		LinkedList<Cliente> clientes;
		clientes = (LinkedList<Cliente>) session.getAttribute("listaCliente");

		model.addAttribute("listaCliente", clientes);
		Cliente c = clientes.get(id - 1);
		model.addAttribute("cliente", c);
		
		
		return "ClienteView";
	}
	
	@RequestMapping(value = "/clienteDelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model, HttpSession session) {
		
		LinkedList<Cliente> clientes;
		clientes = (LinkedList<Cliente>) session.getAttribute("listaCliente");

		model.addAttribute("listaCliente", clientes);
		Cliente c = clientes.get(id-1);
		clientes.remove(id-1);
		
		return "redirect:/cliente";
	}
	
	
}