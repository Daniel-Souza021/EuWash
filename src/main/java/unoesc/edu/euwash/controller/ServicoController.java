package unoesc.edu.euwash.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import unoesc.edu.euwash.DAO.ServicoDAO;
import unoesc.edu.euwash.model.Servico;


@Controller
public class ServicoController {
	
	@Autowired
	private ServicoDAO servicoDao;
	
	
	
	@RequestMapping(path = "/servico", method = RequestMethod.GET)
	public String acessoServico(Model model, HttpSession session) {
		
		
	List<Servico> servicos = this.servicoDao.getServicos();
	
		model.addAttribute("listaServico", servicos);
		model.addAttribute("servico", new Servico());
		
		return "ServicoView";
	}
	
	
	
	@RequestMapping(path = "/servicoSave", method = RequestMethod.POST)
	public String servicoSave(@ModelAttribute("servico") Servico servico, HttpSession session) {
		
		
		if (servico.getId() == 0) {
			this.servicoDao.insertServico(servico);
		} else {
			this.servicoDao.updateServico(servico);
		}
		
	
		return "redirect:/servico";
	}
	
	
	
	@RequestMapping(value = "/servicoEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		
	List<Servico> servicos = this.servicoDao.getServicos();
		
		Servico s = this.servicoDao.getServicoById(id);
		model.addAttribute("listaServico", servicos);
		model.addAttribute("servico", s);
		
		
		return "ServicoView";
	}
	

	@RequestMapping(value = "/servicoDelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model, HttpSession session) {
		

		Servico s = this.servicoDao.getServicoById(id);
		this.servicoDao.deleteServico(s);
		
		
		return "redirect:/servico";
	}
	
	public ServicoDAO getServicoDao() {
		return servicoDao;
	}

	public void setServicoDao(ServicoDAO servicoDao) {
		this.servicoDao = servicoDao;
	}
	
	
}