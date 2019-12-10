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

import java_20191210.dto.SalGradeDto;;


public class SalGradeDao {
	// 1. singleton
	private static SalGradeDao single; 
	private SalGradeDao() {}
	public static SalGradeDao getInstance() {
		if(single == null) {
			single = new SalGradeDao();
		}
		return single;
	}
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public boolean insert(SalGradeDto dto) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = null;
		
		try {
			String abs = "C:\\dev\\io\\infomation\\info.txt";
			String[] conPara = new String[3];
			br = new BufferedReader(new FileReader(abs));
			
			for (int i = 0; i < conPara.length; i++) {
				conPara[i] = br.readLine();
			}
			
			int index = 0;
			con = DriverManager.getConnection(conPara[index++],conPara[index++],conPara[index++]);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO salgrade(grade, losal, hisal) values(?,?,?)");
			
			ps = con.prepareStatement(sql.toString());
			
			index = 0;
			ps.setInt(++index, dto.getGrade());
			ps.setInt(++index, dto.getLosal());
			ps.setInt(++index, dto.getHisal());
			ps.executeUpdate();
			
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
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	
	public boolean update(SalGradeDto dto) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		BufferedReader br = null;
		
		try {
			String abs = "C:\\dev\\io\\infomation\\info.txt";
			String[] conPara = new String[3];
			br = new BufferedReader(new FileReader(abs));
			
			for (int i = 0; i < conPara.length; i++) {
				conPara[i] = br.readLine();
			}
			
			int index = 0;
			con = DriverManager.getConnection(conPara[index++],conPara[index++],conPara[index++]);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE salgrade SET losal = ? , hisal = ? WHERE grade = ?");
			
			ps = con.prepareStatement(sql.toString());
			
			index = 0;
			ps.setInt(++index, dto.getLosal());
			ps.setInt(++index, dto.getHisal());
			ps.setInt(++index, dto.getGrade());
			ps.executeUpdate();
			
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
				if(ps != null) ps.close();
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
	
	public boolean delete(int grade) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		BufferedReader br = null;
		
		try {
			String abs = "C:\\dev\\io\\infomation\\info.txt";
			String[] conPara = new String[3];
			br = new BufferedReader(new FileReader(abs));
			
			for (int i = 0; i < conPara.length; i++) {
				conPara[i] = br.readLine();
			}
			
			int index = 0;
			con = DriverManager.getConnection(conPara[index++],conPara[index++],conPara[index++]);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM salgrade WHERE grade = ?");
			
			ps = con.prepareStatement(sql.toString());
			
			index = 0;
			ps.setInt(++index, grade);
			ps.executeUpdate();
			
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
				if(ps != null) ps.close();
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
	
	
	public ArrayList<SalGradeDto> select() {
		ArrayList<SalGradeDto> list = new ArrayList<SalGradeDto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BufferedReader br = null;
		
		try {
			
			String abs = "C:\\dev\\io\\infomation\\info.txt";
			String[] conPara = new String[3];
			
			br = new BufferedReader(new FileReader(abs));
			
			for (int i = 0; i < conPara.length; i++) {
				conPara[i] = br.readLine();
			}
					
			int index = 0;
			con = DriverManager.getConnection(conPara[index++],conPara[index++],conPara[index++]);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT grade, losal, hisal FROM salgrade ORDER BY grade");
			
			ps = con.prepareStatement(sql.toString());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				index = 0;
				list.add(new SalGradeDto(rs.getInt(++index), rs.getInt(++index), rs.getInt(++index)));
			}
			
			
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
				if(rs!= null) rs.close();
				if(ps!= null) ps.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;		
	}
	
	
	public SalGradeDto select(int grade) {
		SalGradeDto dto = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BufferedReader br = null;
		
		try {
			
			String abs = "C:\\dev\\io\\infomation\\info.txt";
			String[] conPara = new String[3];
			
			br = new BufferedReader(new FileReader(abs));
			
			for (int i = 0; i < conPara.length; i++) {
				conPara[i] = br.readLine();
			}
			
			int index = 0;
			con = DriverManager.getConnection(conPara[index++],conPara[index++],conPara[index++]);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT grade, losal, hisal FROM salgrade WHERE grade = ?");
			
			ps = con.prepareStatement(sql.toString());
			
			index = 0;
			ps.setInt(++index, grade);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				index = 0;
				dto = new SalGradeDto(rs.getInt(++index), rs.getInt(++index), rs.getInt(++index));
			}
			
			
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
				if(rs!= null) rs.close();
				if(ps!= null) ps.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return dto;		
	}
	
	
}
