package jdbcCRUDAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuRead {
	public static void main(String[] args)throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String name = "";
		String password = "";
		try{
			connection = DriverManager.getConnection(url, name, password);
			if(connection != null) {
				statement =connection.createStatement();
				if(statement!=null) {
					String query = "Select Id, Item, Cost from menu";
					 resultSet = statement.executeQuery(query);
					 if(resultSet!=null) {
						 System.out.println("Id\tItem\t\tCost");
						 System.out.println("============================");
						 while(resultSet.next()) {
							 int id =resultSet.getInt(1);
							 String item =resultSet.getString(2);
							 int cost = resultSet.getInt(3);
							 System.out.println(id +"\t" + item +"\t\t" +cost);
						 }
					 }
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(resultSet!=null) {
				resultSet.close();		
			}if(statement!=null) {
				statement.close();
			}if(connection!=null) {
				connection.close();
			}
		}
	}

}
