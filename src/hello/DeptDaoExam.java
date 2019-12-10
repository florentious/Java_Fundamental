package hello;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20191210.dto.DeptDto;

public class DeptDaoExam {
	//1. singleton pattern : Only using 1 object
	//
	private static DeptDaoExam single;
	private DeptDaoExam() {	}
	public static DeptDaoExam getInstance() {
		if(single == null) {
			single = new DeptDaoExam();
		}
		return single;
	}
	
	// static constructor, if make DQL, DML method for static
	// u can use normal constructor
	static {
		try {
			//1. drive Load :  org.mariadb.jdbc.Driver Class를 메모리에 로딩한다.
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Failed DriverLoad");
			e.printStackTrace();
		}
	}
	
	
	public boolean insert(DeptDto dto) {
		boolean isSuccess = false;
		
		// finally con.close();
		Connection con = null;
		// use Query to DB
		PreparedStatement pstmt = null;
		
		BufferedReader br = null;
		
		try {
			// 2. connect database
			// parameter url, id, pw
			// Input/OutputStream use read it(url, id, pw)
			String abs = "C:\\dev\\io\\infomation\\info.txt";
			String[] conPara = new String[3];
			br = new BufferedReader(new FileReader(abs));
			
			for (int i = 0; i < conPara.length; i++) {
				conPara[i] = br.readLine();
			}
			
			int index = 0;
			con = DriverManager.getConnection(conPara[index++],conPara[index++],conPara[index++]);
						
			// 문자열 연결하는일이 많기때문에
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?,?,?)");
			// 3. SQL 문을 전송할 수 있는 PreparedStatement 객체를 생성한다.
			
			pstmt = con.prepareStatement(sql.toString());
			
			// 5. setting BindingVariable(?)
			// parameter 1:위치 2:값
			// ? is binding variable, can use in values()
			index = 0;
			pstmt.setInt(++index, dto.getNo());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getLoc());
			
			// 5. SQL query and return
			pstmt.executeUpdate(); // use DML(insert, update, delete)
			isSuccess = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean update(DeptDto dto) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			// connect db
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoReconnect=true", "acorn12","acorn12");
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?;");
			
			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
			ps.setString(++index, dto.getName());
			ps.setString(++index, dto.getLoc());
			ps.setInt(++index, dto.getNo());
			
			ps.executeUpdate();
			isSuccess = true;
			
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
		
		return isSuccess;
	}
	
	public boolean delete(int deptNo) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoreconnect = true", "acorn12", "acorn12");

			StringBuffer sql = new StringBuffer();

			sql.append("DELETE FROM dept WHERE deptno = ?");

			ps = con.prepareStatement(sql.toString());
			int index = 0;
			ps.setInt(++index, deptNo);
			
			ps.executeUpdate();
			isSuccess = true;
			

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
		
		return isSuccess;
		
	}
	
	// select several rows(dto)
	public ArrayList<DeptDto> select() {
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoreconnect = true", "acorn12","acorn12");
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT deptno, dname, loc FROM dept ORDER BY deptno");
			
			ps = con.prepareStatement(sql.toString());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int index = 0;
				
				//System.out.printf("%2d - deptno : %3d, dname : %10s, loc : %s%n",i,rs.getInt(++index), rs.getString(++index), rs.getString(++index));
				list.add(new DeptDto(rs.getInt(++index),rs.getString(++index),rs.getString(++index)));
				
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
		
		return list;
	}
	
	// select by primary key, just return 1 object;
	public DeptDto select(int deptNo) {
		DeptDto dto = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acorn? autoreconnect = true", "acorn12","acorn12");
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT deptno, dname, loc FROM dept WHERE deptno = ? ");
			
			ps = con.prepareStatement(sql.toString());
			int index = 0;
			ps.setInt(++index, deptNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				index = 0;
				dto = new DeptDto(rs.getInt(++index),rs.getString(++index),rs.getString(++index));
				
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
		
		return dto;
		
	}
	
	
	
}
