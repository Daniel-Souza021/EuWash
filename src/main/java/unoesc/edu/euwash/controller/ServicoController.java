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

import unoesc.edu.euwash.model.Servico;


@Controller
public class ServicoController {
	
	@RequestMapping(path = "/servico", method = RequestMethod.GET)
	public String acessoServico(Model model, HttpSession session) {
		
		List<Servico> servicos;
		if (session.getAttribute("listaServico") == null) {
			servicos = new LinkedList<Servico>();
			session.setAttribute("listaServico", servicos);
		} else
			servicos = (LinkedList<Servico>) session.getAttribute("listaServico");
		
		model.addAttribute("listaServico", servicos);
		model.addAttribute("servico", new Servico());
		
		return "ServicoView";
	}
	
	@RequestMapping(path = "/servicoSave", method = RequestMethod.POST)
	public String servicoSave(@ModelAttribute("servico") Servico servico, HttpSession session) {
		List servicos = (LinkedList<Servico>) session.getAttribute("listaServico");
		
		if (servico.getId() == 0) {
			servicos.add(servico);
			servico.setId(servicos.size());
		} else {
			Servico s = (Servico) servicos.get(servico.getId() - 1);
			s.setDescricao(servico.getDescricao());
			s.setPreco(servico.getPreco());
			s.setCategoria(servico.getCategoria());
		}
		
		
		
		return "redirect:/servico";
	}
	
	@RequestMapping(value = "/servicoEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		
		LinkedList<Servico> servicos;
		servicos = (LinkedList<Servico>) session.getAttribute("listaServico");

		model.addAttribute("listaServico", servicos);
		Servico s = servicos.get(id - 1);
		model.addAttribute("servico", s);
		
		
		return "ServicoView";
	}
	
	@RequestMapping(value = "/servicoDelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model, HttpSession session) {
		
		LinkedList<Servico> servicos;
		servicos = (LinkedList<Servico>) session.getAttribute("listaServico");

		model.addAttribute("listaServico", servicos);
		Servico s = servicos.get(id-1 );
		servicos.remove(id-1);
		
		return "redirect:/servico";
	}
	
	
}