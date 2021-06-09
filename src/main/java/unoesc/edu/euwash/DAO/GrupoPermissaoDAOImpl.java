package unoesc.edu.euwash.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.euwash.model.GrupoPermissao;

@Service(value="GrupoPermissaoDAO")
public class GrupoPermissaoDAOImpl implements GrupoPermissaoDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<GrupoPermissao> getGruposPermissoes() {
		Session session = sessionFactory.getCurrentSession();
		List <GrupoPermissao> gruposPermissoes = (List) session.createQuery("FROM GrupoPermissao").list();
		
		return gruposPermissoes;
	}

	@Override
	@Transactional
	public GrupoPermissao getGrupoPermissaoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		GrupoPermissao e = session.get(GrupoPermissao.class, id);
		return e;
	}


	@Override
	@Transactional
	public void insertGrupoPermissao(GrupoPermissao gruposPermissoes) {
		Session session = sessionFactory.getCurrentSession();
		session.save(gruposPermissoes);
		
	}

	@Override
	@Transactional
	public void updateGrupoPermissao(GrupoPermissao gruposPermissoes) {
		Session session = sessionFactory.getCurrentSession();
		session.update(gruposPermissoes);
	}

	@Override
	@Transactional
	public void deleteGrupoPermissao(GrupoPermissao gruposPermissoes) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(gruposPermissoes);
	}
	
	
}