package jdbcCRUDAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInsertionApp {

	public static void main(String[] args) throws ParseException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the user :");
		String name = sc.next();
		System.out.println("Enter the address of the user :");
		String addr =sc.next();
		System.out.println("Enter the gender of the user :");
		char gen = sc.next().charAt(0);
		System.out.println("Enter the dob : (dd-mm-yyyy)");
		String dob =sc.next();
		System.out.println("Enter the doj : (mm-dd-yyyy)");
		String doj =sc.next();
		System.out.println("Enter date of dom : (yyyy-mm-dd)");
		String dom =sc.next();
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf2 =new SimpleDateFormat("MM-dd-yyyy");
		Date utDate =sdf.parse(dob);
		Date utDate2 = sdf2.parse(doj);
		long time1 = utDate.getTime();
		long time2 = utDate2.getTime();
		java.sql.Date sqldate1 = new java.sql.Date(time1);
		java.sql.Date sqldate2 = new java.sql.Date(time2);
		java.sql.Date mDate = java.sql.Date.valueOf(dom);
		String queryInsert= "insert into userdata(name,address,gender,dob,doj,dom) values (?,?,?,?,?,?)";
		
		try {
			connection = PreparedStmntUtil.getConnection();
			if(connection!=null) {
				pstmt=connection.prepareStatement(queryInsert);
			}if(pstmt!=null) {
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, String.valueOf(gen));
				pstmt.setDate(4,sqldate1);
				pstmt.setDate(5, sqldate2);
				pstmt.setDate(6, mDate);
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Num of rows affected ::" + rowsAffected);
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
