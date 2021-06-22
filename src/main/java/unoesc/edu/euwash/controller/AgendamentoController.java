package unoesc.edu.euwash.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.euwash.DAO.AgendamentoDAO;
import unoesc.edu.euwash.model.Agendamento;

@ManagedBean(name = "agendamentoMB")
@RequestScoped
public class AgendamentoController {

	@ManagedProperty(value = "#{AgendamentoDAO}")
	private AgendamentoDAO agendamentoDao;

	private Agendamento agendamento = new Agendamento();
	private List<Agendamento> agendamentos;

	public void agendamentosave() {
		if (agendamento.getId() == 0) {
			this.agendamentoDao.insertAgendamento(agendamento);
		} else {
			this.agendamentoDao.updateAgendamento(agendamento);
		}

	}

	public void edit(int id) {

		this.agendamento = this.agendamentoDao.getAgendamentoById(id);
	}

	public void delete(int id) {

		Agendamento e = this.agendamentoDao.getAgendamentoById(id);
		this.agendamentoDao.deleteAgendamento(e);

	}

	public AgendamentoDAO getAgendamentoDao() {
		return agendamentoDao;
	}

	public void setAgendamentoDao(AgendamentoDAO agendamentoDao) {
		this.agendamentoDao = agendamentoDao;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agendamento> getAgendamentos() {
		this.agendamentos = agendamentoDao.getAgendamentos();
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	
	
}