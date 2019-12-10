package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo {

	
	public static void main(String[] args) {
		
		try {
			//1. drive Load :  org.mariadb.jdbc.Driver Class를 메모리에 로딩한다.
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Success DriverLoad");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// finally con.close();
		Connection con = null;
		// use Query to DB
		PreparedStatement pstmt = null;
		
		try {
			// 2. connect database
			// parameter url, id, pw
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoReconnect=true", "acorn12", "acorn12");
			
			System.out.println("Success Connected DataBase");
			
			// 문자열 연결하는일이 많기때문에
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?,?,?)");
			// 3. SQL 문을 전송할 수 있는 PreparedStatement 객체를 생성한다.
			
			pstmt = con.prepareStatement(sql.toString());
			
			// 5. setting BindingVariable(?)
			// parameter 1:위치 2:값
			// ? is binding variable, can use in values()
			pstmt.setInt(1, 60);
			pstmt.setString(2, "ANAYLSIS");
			pstmt.setString(3, "LA");
			
			// 5. SQL query and return
			
			int result = pstmt.executeUpdate(); // use DML(insert, update, delete)
			
			System.out.println("updated colm : "+ result);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
