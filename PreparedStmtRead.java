package in.ineuron.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmtRead {
	public static void main(String[] args) throws SQLException {
	Connection connection = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the id :");
	int id=sc.nextInt();
	String sqlQuerySelect = "select SID,SNAME,SAGE,SADDR from Student where SID =?";
	try {
		connection = PreparedStmntUtil.getConnection();
		if (connection != null) {
			pstmt = connection.prepareStatement(sqlQuerySelect);
			if (pstmt != null) {
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
			}
			if (rs != null) {
				if(rs.next()) {
					System.out.println("SID\tSNAME\tSAGE\tSADDR");
					System.out.println(
							rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
				}else {
					System.out.println("Record not available for the given id :: " + id);
				}
			}
		}
	} catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		PreparedStmntUtil.closeConnection(rs, pstmt, connection);
	}if(sc!=null) {
		sc.close();
	}
	}

}
