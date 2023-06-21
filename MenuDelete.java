package jdbcCRUDAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuDelete {
	public static void main(String[] args) throws SQLException{
		Connection connection= null;
		Statement statement = null;
		ResultSet resultset = null;
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String name = "";
		String password = "";
		try {
			connection = DriverManager.getConnection(url, name, password);
			if(connection != null) {
				statement = connection.createStatement();
				if(statement != null) {
					String query = "delete from menu where Id=2";
					int rows = statement.executeUpdate(query);
					System.out.println("Item deleted succesfully....");
					}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
			
		}
	}

}
