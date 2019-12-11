package java_20191211.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java_20191211.dto.EmpDto;

public class EmpDao {
	// read
	private static String url;
	private static String user;
	private static String pw;

	// singleton
	private static EmpDao single;

	private EmpDao() {
	}

	public static EmpDao getInstance() {
		if (single == null) {
			single = new EmpDao();
		}
		return single;
	}

	static {
/*
		// get Information for txt
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("C:\\dev\\io\\infomation\\info2.txt"));
			driver = br.readLine();
			abs = br.readLine();
			id = br.readLine();
			pw = br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		String driver = null;
		
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream("C:\\dev\\workspace\\Java_Fundamental\\src\\java_20191211\\jdbc.properties");
			prop = new Properties();
			prop.load(fis);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pw = prop.getProperty("password");

			Class.forName(driver);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public boolean insert(EmpDto dto) {
		boolean isSuccess = false;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url,user,pw);

			StringBuffer sql = new StringBuffer();

			sql.append("INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES(?,?,?,?,CURDATE(),?,?,?)");
			ps = con.prepareStatement(sql.toString());

			int index = 0;
			ps.setInt(++index, dto.getNo());
			ps.setString(++index, dto.getName());
			ps.setString(++index, dto.getJob());
			ps.setInt(++index, dto.getMgr());
			ps.setInt(++index, dto.getSal());
			ps.setInt(++index, dto.getComm());
			ps.setInt(++index, dto.getDeptNo());

			ps.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con,ps,null);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public boolean update(EmpDto dto) {
		boolean isSuccess = false;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url,user,pw);

			StringBuffer sql = new StringBuffer();

			sql.append("UPDATE emp SET ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno = ?");
			ps = con.prepareStatement(sql.toString());

			int index = 0;
			ps.setString(++index, dto.getName());
			ps.setString(++index, dto.getJob());
			ps.setInt(++index, dto.getMgr());
			ps.setString(++index, dto.getHireDate());
			ps.setInt(++index, dto.getSal());
			ps.setInt(++index, dto.getComm());
			ps.setInt(++index, dto.getDeptNo());
			ps.setInt(++index, dto.getNo());
			
			ps.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con,ps,null);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public boolean update(EmpDto dto, int no) {
		boolean isSuccess = false;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url,user,pw);

			StringBuffer sql = new StringBuffer();

			sql.append("UPDATE emp SET empno =?, ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno = ?");
			ps = con.prepareStatement(sql.toString());

			int index = 0;
			ps.setInt(++index, dto.getNo());
			ps.setString(++index, dto.getName());
			ps.setString(++index, dto.getJob());
			ps.setInt(++index, dto.getMgr());
			ps.setString(++index, dto.getHireDate());
			ps.setInt(++index, dto.getSal());
			ps.setInt(++index, dto.getComm());
			ps.setInt(++index, dto.getDeptNo());
			ps.setInt(++index, no);
			
			ps.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con,ps,null);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public boolean delete(int no) {
		boolean isSuccess = false;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url,user,pw);

			StringBuffer sql = new StringBuffer();

			sql.append("DELETE FROM emp WHERE empno =?");
			ps = con.prepareStatement(sql.toString());

			int index = 0;
			ps.setInt(++index, no);
			
			ps.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con,ps,null);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public ArrayList<EmpDto> select(int start, int len) {
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url,user,pw);

			StringBuffer sql = new StringBuffer();

			sql.append("SELECT empno, ename, job, mgr, date_format(hiredate,'%Y/%m/%d'), sal, comm, deptno FROM emp ORDER BY hiredate DESC LIMIT ?, ? ");
			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
			ps.setInt(++index, start);
			ps.setInt(++index, len);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				index = 0;
				list.add(new EmpDto(rs.getInt(++index),rs.getString(++index),rs.getString(++index),rs.getInt(++index),
						rs.getString(++index),rs.getInt(++index),rs.getInt(++index),rs.getInt(++index)));
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public EmpDto select(int empno) {
		EmpDto dto = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url,user,pw);

			StringBuffer sql = new StringBuffer();

			sql.append("SELECT empno, ename, job, mgr, date_format(hiredate,'%Y/%m/%d'), sal, comm, deptno FROM emp WHERE empno = ? ");
			ps = con.prepareStatement(sql.toString());
			int index = 0;
			ps.setInt(++index, empno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				index = 0;
				dto = new EmpDto(rs.getInt(++index),rs.getString(++index),rs.getString(++index),rs.getInt(++index),
						rs.getString(++index),rs.getInt(++index),rs.getInt(++index),rs.getInt(++index));
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	// refactoring -> extract method 자동으로 메서드 빼주는 코드
	private void close(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (rs != null) rs.close();
		if (ps != null) ps.close();
		if (con != null) con.close();
	}

}
