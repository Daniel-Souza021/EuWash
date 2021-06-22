package unoesc.edu.euwash.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.euwash.DAO.GrupoPermissaoDAO;
import unoesc.edu.euwash.model.GrupoPermissao;

@ManagedBean(name = "grupoPermissaoMB")
@RequestScoped
public class GrupoPermissaoController {

	@ManagedProperty(value = "#{GrupoPermissaoDAO}")
	private GrupoPermissaoDAO grupoPermissaoDao;

	private GrupoPermissao grupoPermissao = new GrupoPermissao();
	private List<GrupoPermissao> gruposPermissoes;

	public void grupopermissaosave() {

		if (grupoPermissao.getId() == 0) {
			this.grupoPermissaoDao.insertGrupoPermissao(grupoPermissao);
		} else {
			this.grupoPermissaoDao.updateGrupoPermissao(grupoPermissao);
		}
		this.grupoPermissao = new GrupoPermissao();

	}

	public void edit(int id) {

		this.grupoPermissao = this.grupoPermissaoDao.getGrupoPermissaoById(id);
	}

	public void delete(int id) {

		GrupoPermissao e = this.grupoPermissaoDao.getGrupoPermissaoById(id);
		this.grupoPermissaoDao.deleteGrupoPermissao(e);
		this.grupoPermissao = new GrupoPermissao();
	}

	public GrupoPermissaoDAO getGrupoPermissaoDao() {
		return grupoPermissaoDao;
	}

	public void setGrupoPermissaoDao(GrupoPermissaoDAO grupoPermissaoDao) {
		this.grupoPermissaoDao = grupoPermissaoDao;
	}

	public GrupoPermissao getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(GrupoPermissao grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}

	public List<GrupoPermissao> getGruposPermissoes() {
		this.gruposPermissoes = grupoPermissaoDao.getGruposPermissoes();
		return gruposPermissoes;
	}

	public void setGruposPermissoes(List<GrupoPermissao> gruposPermissoes) {
		this.gruposPermissoes = gruposPermissoes;
	}
	
	


}