package java_20191125;

public class StaticDemo {
	static String name;
	int age;
	
	public void m1() {
		name = "sung";
		age = 10;
		m2();
		m4();
	}
	public void m2() {
		System.out.println("instatnce method m2()");
	}
	
	public static void m3() {
		StaticDemo sd = new StaticDemo();	//static에서는 instance를 사용하기 위해선 새로 객체를 선언해서 사용해야함
		name = "sung";
		// age =10;
		// m2();
		sd.age = 10;
		sd.m2();
		m4();		
	}
	
	public static void m4() {
		System.out.println("instatnce method m4()");
	}
}
