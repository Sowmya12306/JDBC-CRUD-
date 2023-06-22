package in.ineuron.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStmntUtil {
	private PreparedStmntUtil() {}	//private construtor to disallow object creation
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/ineuron";
		String user = "root";
		String password = "MySQL@001";

		connection = DriverManager.getConnection(url, user, password);
		if (connection != null)
			return connection;
		return connection;
	}
	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
