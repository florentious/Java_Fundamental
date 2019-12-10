package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteDemo {

	public static void main(String[] args) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("driverLoading");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoreconnect = true", "acorn12",
					"acorn12");
			System.out.println("db connect");

			StringBuffer sql = new StringBuffer();

			sql.append("DELETE FROM dept WHERE deptno = ?");

			ps = con.prepareStatement(sql.toString());
			
			ps.setInt(1, 70);
			
			int result = ps.executeUpdate();
			
			System.out.println("updated column : " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
