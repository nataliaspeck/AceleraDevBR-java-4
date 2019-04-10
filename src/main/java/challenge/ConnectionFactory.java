package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException {
		Connection con = null;
		try {
			String url = "jdbc:sqlite:./src/main/resources/database.sqlite";
			con = DriverManager.getConnection(url);
			return con;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}