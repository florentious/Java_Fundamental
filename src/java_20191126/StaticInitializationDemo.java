package java_20191126;

// i18n
// i10l
public class StaticInitializationDemo {
	int age;			// instance variable
	static String title;	// static variable
	
	static {
		System.out.println("static block");
		title = "모기지론";
	}
	// 이렇게하면 default 생성자는 실행되나
	public StaticInitializationDemo() {
		this(0);
	}
	
	// 생성자의 접근 한정자는 객체 생성과 관련있다. 
	private StaticInitializationDemo(int age) {
		this.age = age;
		System.out.println("constructor");
	}
	
	public void print() {
		System.out.println(title);
		System.out.println(age);
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		new StaticInitializationDemo(10);
		new StaticInitializationDemo(30).print();	// 
		
	}
}	
	