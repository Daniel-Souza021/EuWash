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

import unoesc.edu.euwash.DAO.EmpresaDAO;
import unoesc.edu.euwash.model.Empresa;



@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaDAO empresaDao;
	
	@RequestMapping(path = "/empresa", method = RequestMethod.GET)
	public String acessoEmpresa(Model model, HttpSession session) {
		
		
	List<Empresa> empresas = this.empresaDao.getEmpresas();
	
		model.addAttribute("listaEmpresa", empresas);
		model.addAttribute("empresa", new Empresa());
		
		return "EmpresaView";
	}
	
	@RequestMapping(path = "/empresaSave", method = RequestMethod.POST)
	public String empresaSave(@ModelAttribute("empresa") Empresa empresa, HttpSession session) {
		
		
		if (empresa.getId() == 0) {
			this.empresaDao.insertEmpresa(empresa);
		} else {
			this.empresaDao.updateEmpresa(empresa);
		}
		
	
		return "redirect:/empresa";
	}
	
	@RequestMapping(value = "/empresaEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		
	List<Empresa> empresas = this.empresaDao.getEmpresas();
		
		Empresa e = this.empresaDao.getEmpresaById(id);
		model.addAttribute("listaEmpresa", empresas);
		model.addAttribute("empresa", e);
		
		
		return "EmpresaView";
	}
	
	@RequestMapping(value = "/empresaDelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model, HttpSession session) {
		

		Empresa e = this.empresaDao.getEmpresaById(id);
		this.empresaDao.deleteEmpresa(e);
		
		
		return "redirect:/empresa";
	}
	
	

	public EmpresaDAO getEmpresaDao() {
		return empresaDao;
	}

	public void setEmpresaDao(EmpresaDAO empresaDao) {
		this.empresaDao = empresaDao;
	}
	
}