package jdbcCRUDAssignment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateRetrivalApp {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the user :: ");
		String name = sc.next();		
		String queryRead= "select name,address,gender,dob,doj,dom from userdata where name=? ";
		try {
			connection = PreparedStmntUtil.getConnection();
			if(connection!= null) {
				pstmt = connection.prepareStatement(queryRead);
			}if(pstmt!= null) {
				pstmt.setString(1, name);
				resultSet = pstmt.executeQuery();
			}if(resultSet!= null) {
			      if(resultSet.next()) {
			    	  System.out.println("name\taddress\tgender\tdob\tdoj\tdom");
				String user = resultSet.getString(1);
				String addr = resultSet.getString(2);
				char gen = resultSet.getString(3).charAt(0);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String dob = sdf.format(resultSet.getDate(4));
				String doj = sdf.format(resultSet.getDate(5));
				String dom = sdf.format(resultSet.getDate(6));
				System.out.println(user + "\t"+ addr+ "\t"+gen+ "\t"+dob+ "\t"+doj+ "\t"+dom);			
			      }else {
			    	  System.out.println("Record not found with given name :: " + name);
			      }
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			PreparedStmntUtil.closeConnection(null, pstmt, connection);
		}
		if(sc!=null) {
			sc.close();
		}
	}

}
