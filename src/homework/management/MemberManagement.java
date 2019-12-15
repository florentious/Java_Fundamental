package homework.management;

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
import java.util.Scanner;

public class MemberManagement {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	// need to use singleton pattern
	private static MemberManagement single;
	
	static {
		FileInputStream fis = null;
		Properties prop = null;
		
		try {
			fis = new FileInputStream("D:\\dev\\workspace\\Java_Fundamental\\src\\homework\\management\\jdbc.properties");
			prop = new Properties();
			prop.load(fis);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("uesr");
			password = prop.getProperty("password");
			
			Class.forName(driver);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private MemberManagement() {
	
	}
	
	// singleton
	
	public MemberManagement getInstance() {
		if(single == null) {
			single = new MemberManagement();
		}
		return single;
	}
	
	
	public void start() {
		print();
		String index = console("번호를 선택하세요 > ");
		run(index);
	}
	
	private void print() {
		System.out.println("*******************************************************************");
		System.out.println("****  1)Insert  2)Update  3)Delete  4)Search  5)Check  6)Exit  ****");
		System.out.println("*******************************************************************");
		
	}
	private String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	private void run(String index) {
		if(index.equals("1")) {
			//insert
			insert();
		}else if(index.equals("2")) {
			//update
			update();
		}else if(index.equals("3")) {
			//delete
			delete();
		}else if(index.equals("4")) {
			//search
			search();
		}else if(index.equals("5")) {
			//check
			check();
		}else if(index.equals("6")) {
			//exit
			System.out.println("Thanks for using this Management");
		}else {
			//exit
			System.out.println("사요나라");
			
		}
		
		
	}
	
	// insert
	// 1. 아이디를 입력받는다.
	// 2. 이름을 입력받는다.
	// 3. ArrayList에 멤버를 추가한다. -> database에 멤버를 추가한다.
	// 4. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 5. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	
	private void insert() {
		// requirement 1,2
		
		//check duplicate ID
		// 이름은 같을수 있으나 ID는 중복되어선 안된다 unique해야함
		
		// requirement 3
		// 회원 이름을 확인하여 같으면 재입력해달라고 요구한다. 아이디가 유일무이하게 만든다.
		
		boolean isDuplicate = true;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		while(isDuplicate) {
			String id = console("ID > ");
			String name = console("Name > ");
			
			try {
				con = DriverManager.getConnection(url,id,password);
				
				StringBuffer sql = new StringBuffer();
				
				sql.append("INSERT INTO member(member_id, member_name) VALUES(?,?)");
				
				ps = con.prepareStatement(sql.toString());
				
				int index = 0;
				ps.setString(++index, id);
				ps.setString(++index, name);
				
				ps.executeUpdate();
				
				isDuplicate = false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} 
		
		
		try {
			if(ps !=null) ps.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		//추가된 명단을 확인한다.
		check();
				
		// requirement 4,5,6
		start();
	}
	
	// update
	// 1. 수정할 아이디를 입력받는다.
	// 2. id를가지고 ArrayList에 있는 멤버중에 수정할 아이디를 찾아서 있으면 수정할 이름을 입력받고, ArrayList에 멤버정보를 수정한다.
	//    만약 없으면 "수정할 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. ArrayList에 있는 멤버정보를 모두 출력한다.
	// 4. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 5. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	private void update() {
		String id = console("ID를 입력하세요> ").trim();
		boolean found = false;
		int change = 0;
		
		// requirement 2,3
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT member_id, member_name FROM member WHERE member_id = ?");
			ps = con.prepareStatement(sql.toString());
			int index = 0;
			ps.setString(++index, id);
			
			change = ps.executeUpdate();
			
			if(change == 0) {
				throw new SQLException();
			}
			
			String name = console("Name을 입력하세요> ").trim();
			
			sql.setLength(0); 
			
			sql.append("UPDATE member SET member_name =? WHERE member_id = ?");
			
			ps = con.prepareStatement(sql.toString());
			
			index = 0;			
			ps.setString(++index, name);
			ps.setString(++index, id);
			
			ps.executeUpdate();
			
			found = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
		
		if(found) {
			System.out.println("Update Complete");			
		} else {
			System.out.println("Don't Exist " + id);
		}
		
		// requirement 4,5,6
		start();
		
		
	}
	
	// delete
	// 1. 삭제할 아이디를 입력받는다.
	// 2. id를가지고 ArrayList에 있는 멤버중에 수정할 아이디를 찾아서 있으면 멤버정보를 삭제한다.
	//    만약 없으면 "삭제할 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. ArrayList에 있는 멤버정보를 모두 출력한다.		- 삭제 확인용
	// 4. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 5. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	private void delete() {
		String id = console("ID를 입력하세요> ").trim();
		boolean found = false;
		
		// requirement 2,3
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM member WHERE member_id = ?");
			
			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
			ps.setString(++index, id);
			
			ps.executeUpdate();
			
			found = true;
			
			
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
				//e.printStackTrace();
			}
		}
		
		if(found) {
			System.out.println("Delete Complete");			
		} else {
			System.out.println("Don't Exist " + id);
		}
		
		// requirement 4,5,6
		start();
	}
	
	// search
	// 1. 검색할 아이디를 입력받는다.
	// 2. id를가지고 ArrayList에 있는 멤버중에 검색할 아이디를 찾아서 있으면 멤버정보를 출력하고
	//    만약 없으면 "검색 된 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 4. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 5. 번호를 입력받으면 run() 메서드를 호출한다.
	private void search() {
		String id = console("ID를 입력하세요> ").trim();
		boolean found = false;
		
		Member member = null;
		
		// requirement 2,3
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT member_id, member_name FROM member WHERE member_id = ?");
			
			ps = con.prepareStatement(sql.toString());
			
			int index = 0;
			ps.setString(++index, id);
			
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				index = 0;
				member = new Member(rs.getString(++index),rs.getString(++index));
			}
			
			found = true;
			
			
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
				//e.printStackTrace();
			}
		}
		
		if(found) {
			System.out.println(member);			
		} else {
			System.out.println("Don't Exist " + id);
		}
		
		// requirement 4,5,6
		start();
	}
	
	private void check() {
		//select all
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT member_id, member_name FOR member ORDER BY member_id");
			
			ps = con.prepareStatement(sql.toString());
			
			rs = ps.executeQuery();
			
			//print
			
			int index = 0;
			while(rs.next()) {
				list.add(new Member(rs.getString(++index),rs.getString(++index)));
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
				//e.printStackTrace();
			}
		}
		
		for (Member member : list) {
			System.out.println(member);
		}
		
		System.out.printf("총 회원은 %d명 입니다.\n",list.size());
	}
	
	
}
