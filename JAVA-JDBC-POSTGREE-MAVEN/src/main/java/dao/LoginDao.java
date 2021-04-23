package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import model.BeanLoginTelefone;
import model.Login;

public class LoginDao {

	private Connection connection;

	public LoginDao() {
		connection = SingleConnection.getConnection();
	}

	public Login encontrarUsuario(Long id) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			preparedStatement = connection.prepareStatement("select * from tb_user where id = ?");
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			Login login = null;
			while (resultSet.next()) {
				login = new Login(resultSet.getLong("id"), resultSet.getString("Nome"), resultSet.getString("Email"));

			}

			return login;
		}

		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			SingleConnection.closeStatement(preparedStatement);
			SingleConnection.closeResultSet(resultSet);
		}

	}

	public List<Login> listarLogin() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Login login = null;
		List<Login> logins = new ArrayList<Login>();
		try {
			preparedStatement = connection.prepareStatement("Select * from tb_user");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				login = new Login(resultSet.getLong("id"), resultSet.getString("Nome"), resultSet.getString("email"));
				logins.add(login);
			}
			return logins;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			SingleConnection.closeStatement(preparedStatement);
			SingleConnection.closeResultSet(resultSet);
		}
	}

	public List<BeanLoginTelefone> listLogin_telefones(Long id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BeanLoginTelefone beanLoginTelefone = null;
		List<BeanLoginTelefone> beanLoginTelefones = new ArrayList<BeanLoginTelefone>();
		try {
			preparedStatement = connection.prepareStatement(
					"select nome,email,numero from tb_user tu  inner join tb_telefone tt  on tu.id = tt.id_user  where tu.id = ?;");
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				beanLoginTelefone = new BeanLoginTelefone(resultSet.getString("nome"), resultSet.getString("email"),
						resultSet.getString("numero"));
				beanLoginTelefones.add(beanLoginTelefone);
			}
			return beanLoginTelefones;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			SingleConnection.closeStatement(preparedStatement);
			SingleConnection.closeResultSet(resultSet);
		}
	}

	public void inserirUsuario(Login login) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("INSERT INTO TB_USER (NOME,EMAIL) VALUES (?,?)");
			preparedStatement.setString(1, login.getNome());
			preparedStatement.setString(2, login.getEmail());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			SingleConnection.closeStatement(preparedStatement);
		}
	}

	public void alterarLogin(Login login) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update tb_user set nome = ? , email = ?  where id = ?");
			preparedStatement.setString(1, login.getNome());
			preparedStatement.setString(2, login.getEmail());
			preparedStatement.setLong(3, login.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			SingleConnection.closeStatement(preparedStatement);
		}
	}

	public void excluirLogin(Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete  from tb_user where id = (?)");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		} finally {
			SingleConnection.closeStatement(preparedStatement);
		}
	}

	public void excluirLogin_telefones(Long id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from tb_telefone where id_user = ?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
			preparedStatement = connection.prepareStatement("delete from tb_user where id = ?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}
	
	

}
