package java_20191127.step6;

import java.util.Scanner;

//1. class encapsulation
//2. main class's java reflection 추가

public class StopWatchDemo {
	
	// 부모의 run 만 가지고 있으면 부모를 넣었을때 편하게 실행될 수 있다.
	// abstract class's polymorphism
	public void execute(StopWatch s) {
		s.run();
	}
	
	public static void main(String[] args) throws Exception {
		
		new StopWatchDemo().execute((StopWatch) Class.forName("java_20191127.step6."+ new Scanner(System.in).next()).newInstance());
	}
}
