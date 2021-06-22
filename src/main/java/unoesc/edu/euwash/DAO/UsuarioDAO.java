package unoesc.edu.euwash.DAO;

import java.util.List;

import unoesc.edu.euwash.model.Usuario;
	
public interface UsuarioDAO {

	Usuario getUsuarioById (int id);
	List<Usuario> getUsuarios();
	void insertUsuario(Usuario usuario);
	void updateUsuario(Usuario usuario);
	void deleteUsuario(Usuario usuario);
	Usuario validaLogin(String login, String senha);
	
}