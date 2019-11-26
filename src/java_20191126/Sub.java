package java_20191126;

public class Sub extends Super {
	
	String chicken;
	
	public Sub() {
		super();					// 부모클래스의 default constructor를 호출
	}
	public void gotoSchool() {
		System.out.println("Sub gotoSchool()");
	}
}
