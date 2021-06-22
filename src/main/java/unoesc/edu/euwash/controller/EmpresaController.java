package unoesc.edu.euwash.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.euwash.DAO.EmpresaDAO;
import unoesc.edu.euwash.model.Empresa;



@ManagedBean(name="empresaMB")
@RequestScoped
public class EmpresaController {
	
	@ManagedProperty(value="#{EmpresaDAO}")
	private EmpresaDAO empresaDao;
	
	private Empresa empresa = new Empresa();
	private List<Empresa> empresas = null; 
	
	
	public void empresasave() {
		
		if (empresa.getId() == 0) {
			this.empresaDao.insertEmpresa(empresa);
		} else {
			this.empresaDao.updateEmpresa(empresa);
		}
	
	}
	
	public void edit(int id) {

		this.empresa = this.empresaDao.getEmpresaById(id);
	}
	
	public void delete(int id) {
	
		Empresa e = this.empresaDao.getEmpresaById(id);
		this.empresaDao.deleteEmpresa(e);
		
	}
	

	public EmpresaDAO getEmpresaDao() {
		return empresaDao;
	}

	public void setEmpresaDao(EmpresaDAO empresaDao) {
		this.empresaDao = empresaDao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		if (this.empresas == null)
			this.empresas = this.empresaDao.getEmpresas();
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	

	
	
}