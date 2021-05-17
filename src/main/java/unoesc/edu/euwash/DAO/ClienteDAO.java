package unoesc.edu.euwash.DAO;

import java.util.List;

import unoesc.edu.euwash.model.Cliente;
	
public interface ClienteDAO {

	Cliente getClienteById (int id);
	List<Cliente> getClientes();
	void insertCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void deleteCliente(Cliente cliente);
	
}