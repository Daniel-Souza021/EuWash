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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((agendamentos == null) ? 0 : agendamentos.hashCode());
			result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
			result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
			result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
			result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + id;
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + numero;
			result = prime * result + ((rua == null) ? 0 : rua.hashCode());
			result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
			result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
			result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
			Cliente other = (Cliente) obj;
			if (agendamentos == null) {
				if (other.agendamentos != null)
					return false;
			} else if (!agendamentos.equals(other.agendamentos))
				return false;
			if (bairro == null) {
				if (other.bairro != null)
					return false;
			} else if (!bairro.equals(other.bairro))
				return false;
			if (cidade == null) {
				if (other.cidade != null)
					return false;
			} else if (!cidade.equals(other.cidade))
				return false;
			if (cpf == null) {
				if (other.cpf != null)
					return false;
			} else if (!cpf.equals(other.cpf))
				return false;
			if (data_nascimento == null) {
				if (other.data_nascimento != null)
					return false;
			} else if (!data_nascimento.equals(other.data_nascimento))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id != other.id)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (numero != other.numero)
				return false;
			if (rua == null) {
				if (other.rua != null)
					return false;
			} else if (!rua.equals(other.rua))
				return false;
			if (sobrenome == null) {
				if (other.sobrenome != null)
					return false;
			} else if (!sobrenome.equals(other.sobrenome))
				return false;
			if (telefone == null) {
				if (other.telefone != null)
					return false;
			} else if (!telefone.equals(other.telefone))
				return false;
			if (usuario == null) {
				if (other.usuario != null)
					return false;
			} else if (!usuario.equals(other.usuario))
				return false;
			return true;
		}

	

		@Override
		public String toString() {
			return this.nome;
		}
		
		
	}

