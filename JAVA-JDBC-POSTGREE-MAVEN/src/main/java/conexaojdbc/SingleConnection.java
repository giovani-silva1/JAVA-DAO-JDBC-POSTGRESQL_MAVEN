package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/cursojdbc";
	private static String password = "1234";
	private static String user = "postgres";

	private static Connection conn = null;

	static {
		conectar();
	}

	public SingleConnection() {

		conectar();
	}

	public static void conectar() {
		try {
			if (conn == null) {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void closeStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
