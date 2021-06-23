package unoesc.edu.euwash.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Float preco;
	@Column
	private String categoria;
	@Column(name = "busca_entrega")
	private Boolean buscaEntrega;
	@Column(name = "tempo_medio")
	private Date tempoMedio;
	@Column
	private Boolean disponibilidade;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", referencedColumnName = "id")
	private Empresa empresa;
	
	@OneToMany(mappedBy = "servico")
	List<Agendamento> agendamentos;

	
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
	
	public Float getPreco() {
		return preco;
	}
	
	public void setPreco(Float preco) {
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

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendamentos == null) ? 0 : agendamentos.hashCode());
		result = prime * result + ((buscaEntrega == null) ? 0 : buscaEntrega.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((disponibilidade == null) ? 0 : disponibilidade.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + id;
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((tempoMedio == null) ? 0 : tempoMedio.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (agendamentos == null) {
			if (other.agendamentos != null)
				return false;
		} else if (!agendamentos.equals(other.agendamentos))
			return false;
		if (buscaEntrega == null) {
			if (other.buscaEntrega != null)
				return false;
		} else if (!buscaEntrega.equals(other.buscaEntrega))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (disponibilidade == null) {
			if (other.disponibilidade != null)
				return false;
		} else if (!disponibilidade.equals(other.disponibilidade))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id != other.id)
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (tempoMedio == null) {
			if (other.tempoMedio != null)
				return false;
		} else if (!tempoMedio.equals(other.tempoMedio))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
	
	
	
	
	
	
}