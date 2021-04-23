package program;

import java.util.List;

import org.junit.Test;

import dao.LoginDao;
import model.BeanLoginTelefone;
import model.Login;

public class UserProgram {

	LoginDao loginDao = new LoginDao();

	// metodo de adicionar login
	@Test
	public void addTest() {
		Login login = new Login("carlos", "carlos@live.com");
		Login login2 = new Login("carlosAlmeida", "carlos@live.com");
		Login login3 = new Login("Magda", "magda@live.com");
		Login login4 = new Login("Fra", "fran@live.com");
		Login login5 = new Login("plinio", "plinio@live.com");
		Login login6 = new Login("oswaldo", "oswaldo@live.com");
		Login login7 = new Login("alvaro", "alvaro@live.com");
		Login login8 = new Login("braian", "braian@live.com");

		System.out.println("ADICIONANDO UM LOGIN");
		loginDao.inserirUsuario(login2);
		loginDao.inserirUsuario(login3);
		loginDao.inserirUsuario(login4);
		loginDao.inserirUsuario(login5);
		loginDao.inserirUsuario(login6);
		loginDao.inserirUsuario(login7);
		loginDao.inserirUsuario(login8);
	}

	@Test
	public void encontrarLogin() {
		Login login = loginDao.encontrarUsuario(3L);
		System.out.println(login);
	}

	@Test
	public void logins() {

		List<Login> logins = loginDao.listarLogin();
		for (Login login : logins) {
			System.out.println(login);
		}
	}

	@Test
	public void excluirLogin() {

		loginDao.excluirLogin(16L);
	}
	
	@Test
	public void updateLogin() {
		Login loginUpdate = loginDao.encontrarUsuario(1L);
		loginUpdate.setNome("Novo dado atualizado");
		loginUpdate.setEmail("Novo email atualizado");
		loginDao.alterarLogin(loginUpdate);
	}
	
	@Test
	public void listarUsuariosTelefones() {
		List<BeanLoginTelefone>beanLoginTelefones = loginDao.listLogin_telefones(1L);
		for (BeanLoginTelefone beanLoginTelefone : beanLoginTelefones) {
			System.out.println(beanLoginTelefone);
		}
	}
	
	@Test
	public void excluirUsuariosTelefones() {
		
		loginDao.excluirLogin_telefones(1L);
	}
	

}
