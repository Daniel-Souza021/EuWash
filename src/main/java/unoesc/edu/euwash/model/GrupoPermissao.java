package unoesc.edu.euwash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupos_permissoes")
public class GrupoPermissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_grupos_permissoes")
	private int id;
	
	@Column
	private String descricao;
	@Column
	private int nivel;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}