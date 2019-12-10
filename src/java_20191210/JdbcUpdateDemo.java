package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateDemo {

	
	public static void main(String[] args) {
		
		
		try {
			// driver Loading
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Success DriverLoad");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			// connect db
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoReconnect=true", "acorn12","acorn12");
			System.out.println("Success Connect DB");
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?;");
			
			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
			ps.setString(++index, "MININGS");
			ps.setString(++index, "SILICON VALLEY");
			ps.setInt(++index, 60);
			
			int result = ps.executeUpdate();
			
			System.out.println("updated Column : " + result);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		
		
		
	}
}
