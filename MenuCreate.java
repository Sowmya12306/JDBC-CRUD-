package jdbcCRUDAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuCreate  {
	public static void main(String[] args) throws SQLException{
		Connection connection= null;
		Statement statement = null;
		ResultSet resultset = null;
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String name = "";
		String password = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the Item ");
		int id =sc.nextInt();
		System.out.println("Enter the item to order ");
		String item = sc.next();
		System.out.println("Enter the cost of the item");
		int cost= sc.nextInt();
		try {
			connection = DriverManager.getConnection(url, name, password);
			if(connection != null) {
				statement = connection.createStatement();
				if(statement != null) {
					String query = String.format("insert into menu(Id,Item,Cost) values(%d,'%s',%d)",id,item,cost);
					int rows = statement.executeUpdate(query);
					System.out.println("Item " + item +" added succesfully");
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
			if(sc!=null) {
				sc.close();
				
			}
		}
	}

}
