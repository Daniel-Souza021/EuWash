package unoesc.edu.euwash.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpServletRequest;

import unoesc.edu.euwash.DAO.UsuarioDAO;
import unoesc.edu.euwash.model.Usuario;
import unoesc.edu.euwash.util.SessionContext;
import java.io.IOException;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioController {

	@ManagedProperty(value = "#{UsuarioDAO}")
	private UsuarioDAO usuarioDao;
	
	private boolean logado = false;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	public void usuariosave() {

		if (usuario.getId() == 0) {
			this.usuarioDao.insertUsuario(usuario);
		} else {
			this.usuarioDao.updateUsuario(usuario);
		}
		this.usuario = new Usuario();

	}
	
	public UsuarioController() {
		 Usuario user =	(Usuario) SessionContext.getInstance().getAttribute("usuarioLogado");
			if (user!=null) {
				setLogado(true);
			}
		}
	
	
	public void fazLogin() throws IOException {
		FacesMessage message = null;

		usuario = usuarioDao.validaLogin(this.getUsuario().getLogin(), this.getUsuario().getSenha());
				if (usuario	!=	null) {
			logado = true;
			SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login realizado com sucesso!", this.getUsuario().getLogin());
		}else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no Login!", "Usuário ou senha inválido");
			SessionContext.getInstance().setAttribute("usuarioLogado", null);
			logado = false;
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", logado);

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("index.xhtml");
       // return "redirect:views/Index.xhtml";
	}
	
	
	public void fazLogout() throws IOException {
		FacesMessage message = null;

			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout!","Até mais.");
			SessionContext.getInstance().setAttribute("usuarioLogado", null);
			logado = false;
			usuario = new Usuario();

        FacesContext.getCurrentInstance().addMessage(null, message);

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}


	public void edit(int id) {

		this.usuario = this.usuarioDao.getUsuarioById(id);
	}

	public void delete(int id) {

		Usuario e = this.usuarioDao.getUsuarioById(id);
		this.usuarioDao.deleteUsuario(e);
		this.usuario = new Usuario();
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

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	
	

	
	
}