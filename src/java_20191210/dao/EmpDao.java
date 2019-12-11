package java_20191210.dao;

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

import java_20191210.dto.EmpDto;

public class EmpDao {
	// read
	private static String driver;
	private static String abs;
	private static String id;
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

		// load driver
		try {
			Class.forName(driver);
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
			con = DriverManager.getConnection(abs);

			StringBuffer sql = new StringBuffer();

			sql.append("INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES(?,?,?,?,?,?,?,?)");
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
			con = DriverManager.getConnection(abs);

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
			ps.setInt(++index, dto.getNo());
			
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
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public boolean delete(int empno) {
		boolean isSuccess = false;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(abs);

			StringBuffer sql = new StringBuffer();

			sql.append("DELETE FROM emp WHERE empno =?");
			ps = con.prepareStatement(sql.toString());

			int index = 0;
			ps.setInt(++index, empno);
			
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
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public ArrayList<EmpDto> select() {
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(abs);

			StringBuffer sql = new StringBuffer();

			sql.append("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp ORDER BY empno ");
			ps = con.prepareStatement(sql.toString());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int index = 0;
				list.add(new EmpDto(rs.getInt(++index),rs.getString(++index),rs.getString(++index),rs.getInt(++index),
						rs.getString(++index),rs.getInt(++index),rs.getInt(++index),rs.getInt(++index)));
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
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
			con = DriverManager.getConnection(abs);

			StringBuffer sql = new StringBuffer();

			sql.append("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp WHERE empno = ? ");
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
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dto;
	}

}
