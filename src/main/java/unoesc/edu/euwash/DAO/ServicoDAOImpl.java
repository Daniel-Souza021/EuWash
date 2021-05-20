package unoesc.edu.euwash.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.euwash.model.Servico;

@Service(value="ServicoDAO")
public class ServicoDAOImpl implements ServicoDAO {
	

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Servico> getServicos() {
		Session session = sessionFactory.getCurrentSession();
		List <Servico> servicos = (List) session.createQuery("FROM Servico").list();
		return servicos;
	}


	@Override
	@Transactional
	public Servico getServicoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Servico s = session.get(Servico.class, id);
		return s;
	}


	@Override
	@Transactional
	public void insertServico(Servico servico) {
		Session session = sessionFactory.getCurrentSession();
		session.save(servico);
		
	}

	@Override
	@Transactional
	public void updateServico(Servico servico) {
		Session session = sessionFactory.getCurrentSession();
		session.update(servico);
	}

	@Override
	@Transactional
	public void deleteServico(Servico servico) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(servico);
	}
	
}