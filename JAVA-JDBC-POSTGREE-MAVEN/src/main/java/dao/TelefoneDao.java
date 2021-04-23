package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.Telefone;

public class TelefoneDao {

	private Connection connection;

	public TelefoneDao() {
		this.connection = SingleConnection.getConnection();
	}

	public void cadatrarTelefone(Telefone telefone) {

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO tb_telefone (tipo,numero,id_user) VALUES (?,?,?)");
			preparedStatement.setString(1, telefone.getTipo());
			preparedStatement.setString(2, telefone.getNumero());
			preparedStatement.setLong(3, telefone.getId_user());
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
