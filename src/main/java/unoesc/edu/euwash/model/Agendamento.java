package unoesc.edu.euwash.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_agendamentos")
	private int id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data_agendamento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data_inicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data_final;
	
	@ManyToOne
	@JoinColumn(name = "id_servico")
	Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	Cliente cliente;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Date getData_agendamento() {
		return data_agendamento;
	}

	public void setData_agendamento(Date data_agendamento) {
		this.data_agendamento = data_agendamento;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}

