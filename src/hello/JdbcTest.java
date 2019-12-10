package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("driver loading");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoreconnect = true", "acorn12", "acorn12");
			System.out.println("connection db");
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("");
			
			ps = con.prepareStatement(sql.toString());
			
			ps.setInt(1, 1);
			
			int result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
}
