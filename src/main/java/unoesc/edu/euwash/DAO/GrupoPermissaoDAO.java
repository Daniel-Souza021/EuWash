package unoesc.edu.euwash.DAO;

import java.util.List;

import unoesc.edu.euwash.model.GrupoPermissao;
	
public interface GrupoPermissaoDAO {

	GrupoPermissao getGrupoPermissaoById (int id);
	List<GrupoPermissao> getGruposPermissoes();
	void insertGrupoPermissao(GrupoPermissao grupoPermissao);
	void updateGrupoPermissao(GrupoPermissao grupoPermissao);
	void deleteGrupoPermissao(GrupoPermissao grupoPermissao);
	
}