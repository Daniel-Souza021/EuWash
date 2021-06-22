package unoesc.edu.euwash.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import unoesc.edu.euwash.model.Agendamento;

@Service(value="AgendamentoDAO")
public class AgendamentoDAOImpl implements AgendamentoDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Agendamento> getAgendamentos() {
		Session session = sessionFactory.getCurrentSession();
		List <Agendamento> agendamentos = (List) session.createQuery("FROM Agendamento").list();
		
		return agendamentos;
	}

	@Override
	@Transactional
	public Agendamento getAgendamentoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Agendamento e = session.get(Agendamento.class, id);
		return e;
	}


	@Override
	@Transactional
	public void insertAgendamento(Agendamento agendamento) {
		Session session = sessionFactory.getCurrentSession();
		session.save(agendamento);
		
	}

	@Override
	@Transactional
	public void updateAgendamento(Agendamento agendamento) {
		Session session = sessionFactory.getCurrentSession();
		session.update(agendamento);
	}

	@Override
	@Transactional
	public void deleteAgendamento(Agendamento agendamento) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(agendamento);
	}
	
	
	
	
}