package java_20191125;

public class OverloadingDemo {
	/*
	Overloading의 작성 규칙
	1. 같은 클래스 내
	2. 메서드 이름은 같아야한다.
	3. 매개변수 갯수나 자료형이 달라야한다.
	4. 반환형과 접근 한정자는 같아도 되고, 아니어도 된다.	
	*/
	
	// print method overloading
	public void print(String str) {
		System.out.print(str);
	}
	public void print(int i) {
		System.out.print(i);
	}
	public void print(double d) {
		System.out.print(d);
	}
	public void print(boolean b) {
		System.out.print(b);
	}
	
	public static void main(String[] args) {
		OverloadingDemo o = new OverloadingDemo();
		o.print(true);
		o.print("test");
		o.print(23+34);
		o.print(43.456);
	}
	
	
}
