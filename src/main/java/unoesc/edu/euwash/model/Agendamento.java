package unoesc.edu.euwash.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_agendamentos")
	private int id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_agendamento")
	private Date dataAgendamento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_final")
	private Date dataFinal;
	
	@OneToMany(mappedBy = "agendamento")
	List<Servico> servicos;
	
	@OneToMany(mappedBy = "agendamento")
	List<Cliente> clientes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

	
}

