package in.ineuron.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmtUpdate {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id ::");
		int id = sc.nextInt();
		String queryUpdate = "update Student set SNAME = 'Pooja' where SID=?";
		try {
			con =PreparedStmntUtil.getConnection();
			if(con!=null) {
				ps =con.prepareStatement(queryUpdate);
			}if(ps!=null) {
				ps.setInt(1, id);
				int row =ps.executeUpdate();
				if(row==0)
					System.out.println("row doesn't exists with given id ");
				else
					System.out.println("Row updated succesfully ::" + row);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			PreparedStmntUtil.closeConnection(null, ps, con);
		}
		if(sc!=null) {
			sc.close();
		}
	}

}
