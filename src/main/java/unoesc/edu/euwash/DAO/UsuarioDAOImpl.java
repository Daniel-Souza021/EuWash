package unoesc.edu.euwash.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.euwash.model.Usuario;

@Service(value="UsuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		Session session = sessionFactory.getCurrentSession();
		List <Usuario> usuarios = (List) session.createQuery("FROM Usuario").list();
		
		return usuarios;
	}

	@Override
	@Transactional
	public Usuario getUsuarioById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Usuario e = session.get(Usuario.class, id);
		return e;
	}


	@Override
	@Transactional
	public void insertUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
		
	}

	@Override
	@Transactional
	public void updateUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(usuario);
	}

	@Override
	@Transactional
	public void deleteUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(usuario);
	}

	@Override
	@Transactional
	public Usuario validaLogin(String login, String senha) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario p = (Usuario) session.createQuery("from Usuario where login=:login and senha=:pwd")
								.setParameter("login", login)
								.setParameter("pwd", senha)
								.uniqueResult();
		return p;
	}
	
	
	
	
}