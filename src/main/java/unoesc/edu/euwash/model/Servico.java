package unoesc.edu.euwash.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_servicos")
	private int id;
	@Column
	private String descricao;
	@Column
	private String preco;
	@Column
	private String categoria;
	@Column(name = "busca_entrega")
	private Boolean buscaEntrega;
	@Column(name = "tempo_medio")
	private Date tempoMedio;
	@Column
	private Boolean disponibilidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa")
	Empresa empresa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_agendamento")
	Agendamento agendamento;
	
	@OneToMany(mappedBy = "servico")
	List<Usuario> usuarios;
	
	
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
	
	public String getPreco() {
		return preco;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Boolean getBuscaEntrega() {
		return buscaEntrega;
	}

	public void setBuscaEntrega(Boolean buscaEntrega) {
		this.buscaEntrega = buscaEntrega;
	}

	public Date getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(Date tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
}