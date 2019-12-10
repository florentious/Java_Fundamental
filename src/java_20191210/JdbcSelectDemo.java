package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectDemo {

	
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
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoreconnect = true", "acorn12","acorn12");
			System.out.println("connect DB");
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT deptno, dname, loc FROM dept ORDER BY deptno");
			
			ps = con.prepareStatement(sql.toString());
			
			rs = ps.executeQuery();
			
			int i = 1;
			while(rs.next()) {
				int index = 0;
				System.out.printf("%2d - deptno : %3d, dname : %10s, loc : %s%n",i,rs.getInt(++index), rs.getString(++index), rs.getString(++index));
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}
