package unoesc.edu.euwash.DAO;

import java.util.List;

import unoesc.edu.euwash.model.Agendamento;
	
public interface AgendamentoDAO {

	Agendamento getAgendamentoById (int id);
	List<Agendamento> getAgendamentos();
	void insertAgendamento(Agendamento agendamento);
	void updateAgendamento(Agendamento agendamento);
	void deleteAgendamento(Agendamento agendamento);
	
}