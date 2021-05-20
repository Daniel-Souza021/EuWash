package unoesc.edu.euwash.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.euwash.DAO.ServicoDAO;
import unoesc.edu.euwash.model.Servico;


@ManagedBean(name="servicoMB")
@RequestScoped
public class ServicoController {
	
	@ManagedProperty(value="#{ServicoDAO}")
	private ServicoDAO servicoDao;
	
	private Servico servico = new Servico();
	private List<Servico> servicos; 

	
	public void servicosave() {

		if (servico.getId() == 0) {
			this.servicoDao.insertServico(servico);
		} else {
			this.servicoDao.updateServico(servico);
		}
	}
	
	
	public void edit(int id) {

		this.servico = this.servicoDao.getServicoById(id);

	}
	

	public void delete(int id) {
		
		Servico s = this.servicoDao.getServicoById(id);
		this.servicoDao.deleteServico(s);
		
	}
	
	public ServicoDAO getServicoDao() {
		return servicoDao;
	}

	public void setServicoDao(ServicoDAO servicoDao) {
		this.servicoDao = servicoDao;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public List<Servico> getServicos() {
		this.servicos = servicoDao.getServicos();
		return servicos;
	}


	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	
	
}