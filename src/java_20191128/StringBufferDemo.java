package java_20191128;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		StringBuffer s2 = new StringBuffer("test");
		
		//StringBuffer 클래스는 Object의 equals() 메서드를 overrideing 하지 않았기 때문에 equals()를 사용하면 
		// 참조값 비교만 한다
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		// StringBuffer도 .toString() 되어있음
		System.out.println(s1);
		//값을 비교하고 싶으면 string으로 변환해서 사용할것
		System.out.println(s1.toString().equals(s2.toString()));
		
		StringBuffer sql = new StringBuffer();
		sql.append("select name, age ");
		sql.append("from member ");
		sql.append("where name = 'name' ");
		sql.append("order by name desc ");
		
		System.out.println(sql);
		
		//delete
		sql.setLength(0);
		
		sql.append("select no, writer ");
		sql.append("from board");
		
		System.out.println(sql);
		
		
	}
}
