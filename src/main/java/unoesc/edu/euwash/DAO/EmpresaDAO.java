package unoesc.edu.euwash.DAO;

import java.util.List;

import unoesc.edu.euwash.model.Empresa;
	
public interface EmpresaDAO {

	Empresa getEmpresaById (int id);
	List<Empresa> getEmpresas();
	void insertEmpresa(Empresa empresa);
	void updateEmpresa(Empresa empresa);
	void deleteEmpresa(Empresa empresa);
	
}