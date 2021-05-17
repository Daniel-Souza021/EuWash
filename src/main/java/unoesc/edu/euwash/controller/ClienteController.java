package unoesc.edu.euwash.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import unoesc.edu.euwash.DAO.ClienteDAO;
import unoesc.edu.euwash.model.Cliente;
import unoesc.edu.euwash.model.Empresa;
import unoesc.edu.euwash.model.Servico;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDao;
	
	@RequestMapping(path = "/cliente", method = RequestMethod.GET)
	public String acessoServico(Model model, HttpSession session) {
		
		List<Cliente> clientes = this.clienteDao.getClientes();
		
		model.addAttribute("listaCliente", clientes);
		model.addAttribute("cliente", new Cliente());
		
		return "ClienteView";
	}
	
	@RequestMapping(path = "/clienteSave", method = RequestMethod.POST)
public String clientesave(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
		
		
		if (cliente.getId() == 0) {
			this.clienteDao.insertCliente(cliente);
		} else {
			this.clienteDao.updateCliente(cliente);
		}
		
		
		return "redirect:/cliente";
	}
	
	@RequestMapping(value = "/clienteEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		
		List<Cliente> clientes = this.clienteDao.getClientes();
			
			Cliente c = this.clienteDao.getClienteById(id);
			model.addAttribute("listaCliente", clientes);
			model.addAttribute("cliente", c);
				
		return "ClienteView";
	}
	
	@RequestMapping(value = "/clienteDelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model, HttpSession session) {
		
		Cliente c = this.clienteDao.getClienteById(id);
		this.clienteDao.deleteCliente(c);
		
		return "redirect:/cliente";
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}
}