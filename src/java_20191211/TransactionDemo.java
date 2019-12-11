package java_20191211;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {

	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		boolean isSuccess = false;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/acorn","acorn12","acorn12");
			
			StringBuffer sql = new StringBuffer();
			
			con.setAutoCommit(false); // transaction start

			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(80,'aaa','aaa')");
			ps1 = con.prepareStatement(sql.toString());
			ps1.executeUpdate();
			
			sql.setLength(0);
			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(90,'bbb','bbb)");
			
			ps2 = con.prepareStatement(sql.toString());
			ps2.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(isSuccess) {
					con.commit();			// transaction success end;
				}else {
					con.rollback();			// transaction fail end;
				}
				con.setAutoCommit(true);	// connection pool - 원상복구해야됨;
											// connection pool 에선 autocommit이 저장이 안되서 다른 명령어가 안먹음
											// connection pool 을 사용할때는 반드시 사용해야 서버가 안죽어요
				
				if(ps2 != null) ps2.close();
				if(ps1 != null) ps1.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}
}
