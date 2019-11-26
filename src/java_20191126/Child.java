package java_20191126;

public class Child extends Parent {
	double height = 170.23;
	
	// overriding :  보무의 메서드를 재정의
	// 1. 메서드 이름, 매개변(타입,갯수), 반환형 일치
	// 2. 접근 한정자는 부모보다 자식이 상위이거나 같으면 됨
	public void work() {
		//super.work();							// 부모의 기능을 자식에서 호출할때 사용함.
		System.out.println("Child work()");
	}
	
	
	public void playGame() {
		System.out.println("Child playGame()");
	}

}
