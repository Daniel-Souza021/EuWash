package unoesc.edu.euwash.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.euwash.DAO.UsuarioDAO;
import unoesc.edu.euwash.model.Usuario;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioController {

	@ManagedProperty(value = "#{UsuarioDAO}")
	private UsuarioDAO usuarioDao;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	public void usuariosave() {

		if (usuario.getId() == 0) {
			this.usuarioDao.insertUsuario(usuario);
		} else {
			this.usuarioDao.updateUsuario(usuario);
		}

	}

	public void edit(int id) {

		this.usuario = this.usuarioDao.getUsuarioById(id);
	}

	public void delete(int id) {

		Usuario e = this.usuarioDao.getUsuarioById(id);
		this.usuarioDao.deleteUsuario(e);

	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		this.usuarios = usuarioDao.getUsuarios();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	

	
	
}