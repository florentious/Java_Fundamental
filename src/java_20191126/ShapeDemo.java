package java_20191126;

public class ShapeDemo {
	// 추상클래스의 다형성
	public static void run(Shape s) {
		s.draw();
	}
	
	public static void main(String[] args) {
		// 추상 클래스는 객체를 생성할 수 없음
		Shape s1 = new Rectangle();
		s1.draw();
		s1.x = 1;
		s1.y = 2;
		
		Shape s2 = new Triangle();
		s2.draw();
				
		run(new Rectangle());
		run(new Triangle());
	}
}
