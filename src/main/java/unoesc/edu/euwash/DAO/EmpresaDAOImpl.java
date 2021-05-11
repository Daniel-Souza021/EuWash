package unoesc.edu.euwash.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.euwash.model.Empresa;

@Repository
public class EmpresaDAOImpl implements EmpresaDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Empresa> getEmpresas() {
		Session session = sessionFactory.getCurrentSession();
		List <Empresa> empresas = (List) session.createQuery("FROM Empresa").list();
		
		return empresas;
	}

	

	@Override
	@Transactional
	public Empresa getEmpresaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Empresa e = session.get(Empresa.class, id);
		return e;
	}


	@Override
	@Transactional
	public void insertEmpresa(Empresa empresa) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empresa);
		
	}

	@Override
	@Transactional
	public void updateEmpresa(Empresa empresa) {
		Session session = sessionFactory.getCurrentSession();
		session.update(empresa);
	}

	@Override
	@Transactional
	public void deleteEmpresa(Empresa empresa) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(empresa);
	}
	
	
	
	
}