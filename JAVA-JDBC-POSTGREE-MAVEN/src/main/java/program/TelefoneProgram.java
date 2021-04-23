package program;

import org.junit.Test;

import dao.TelefoneDao;
import model.Telefone;

public class TelefoneProgram {

	TelefoneDao telefoneDao = new TelefoneDao();
	
	
	@Test
	public void adicionarTelefone() {
		
		Telefone telefone = new Telefone("COM","114417890",2L);
		telefoneDao.cadatrarTelefone(telefone);
	}
}
