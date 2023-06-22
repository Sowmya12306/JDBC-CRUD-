package in.ineuron.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmtDelete {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement prsmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id :: ");
		int id =sc.nextInt();
		String sqlquerydel= "delete from Student where SID = ?";
		try {
			con = PreparedStmntUtil.getConnection();
			if (con != null) {
				prsmt = con.prepareStatement(sqlquerydel);
				if (prsmt != null) {
					prsmt.setInt(1, id);
					Integer row = prsmt.executeUpdate();
					if(row==0)
					System.out.println("nothing to delete!!!");
					else{
						System.out.println("row deleted successfully....");
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			PreparedStmntUtil.closeConnection(null, prsmt, con);
		}
		if(sc!=null) {
			sc.close();
		}
		

	}

}
