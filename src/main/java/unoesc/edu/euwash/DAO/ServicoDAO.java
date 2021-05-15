package unoesc.edu.euwash.DAO;

import java.util.List;

import unoesc.edu.euwash.model.Servico;


public interface ServicoDAO {

	Servico getServicoById (int id);
	List<Servico> getServicos();
	void insertServico(Servico servico);
	void updateServico(Servico servico);
	void deleteServico(Servico servico);
	
}