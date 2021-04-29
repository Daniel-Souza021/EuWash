package unoesc.edu.euwash.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente implements Serializable{
	
		private String nome;
		private String sobrenome;
		private String telefone;
		private Date dataNasc;

		
		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}

		public Date getDataNasc() {
			return dataNasc;
		}

		public void setDataNasc(Date dataNasc) {
			
			this.dataNasc = dataNasc;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDataNasFormated() {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			if (this.dataNasc == null)
				return format.format(new Date());
			
			return format.format(this.dataNasc);
		}
		
		public String getDataNasDateInput() {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if (this.dataNasc == null)
				return format.format(new Date());
			
			return format.format(this.dataNasc);
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		

	}

