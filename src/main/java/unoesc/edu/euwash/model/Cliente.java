package unoesc.edu.euwash.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente{
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk_clientes")
		private int id;
		
		@Column
		private String nome;
		@Column
		private String sobrenome;
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private Date data_nascimento;
		@Column
		private String telefone;
		@Column
		private String cpf;
		@Column
		private int numero;
		@Column
		private String rua;
		@Column
		private String bairro;
		@Column
		private String cidade;
		@Column
		private String email;
		
		@OneToMany(mappedBy = "cliente")
		List<Agendamento> agendamentos;

		@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
		private Usuario usuario;
		
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}


		public Date getData_nascimento() {
			return data_nascimento;
		}

		public void setData_nascimento(Date data_nascimento) {
			this.data_nascimento = data_nascimento;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Agendamento> getAgendamentos() {
			return agendamentos;
		}

		public void setAgendamentos(List<Agendamento> agendamentos) {
			this.agendamentos = agendamentos;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

	
		
		
		
	}

