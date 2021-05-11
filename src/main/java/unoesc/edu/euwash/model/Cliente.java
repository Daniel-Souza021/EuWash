package unoesc.edu.euwash.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente{
	
		private int id;
		private String nome;
		private String sobrenome;
		private String telefone;
		private String dataNasc;

		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}

		public String getDataNasc() {
			return dataNasc;
		}

		public void setDataNasc(String dataNasc) {
			
			this.dataNasc = dataNasc;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
	}

