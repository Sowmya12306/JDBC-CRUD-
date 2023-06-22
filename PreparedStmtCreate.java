package in.ineuron.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStmtCreate {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of the student :");
		int id = sc.nextInt();
		System.out.println("Enter name of the student :");
		String name = sc.next();
		System.out.println("Enter age of the Student :");
		int age = sc.nextInt();
		System.out.println("Enter city og the student:");
		String city =sc.next();
		String sqlInsertQuery = "insert into Student(SID,SNAME,SAGE,SADDR) values (?,?,?,?)";		
		try {
			connection = PreparedStmntUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, city);
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Number of rows Affected ::" + rowsAffected);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			PreparedStmntUtil.closeConnection(null, pstmt, connection);
		}
		if(sc!=null) {
			sc.close();
		}

}
}
