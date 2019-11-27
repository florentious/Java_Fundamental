package java_20191127.step5;

// 1. 실제 비지니스 로직을 해당 클래스에 추가하자
// 2. 클래스들의 공통 요소가 있으면 부모 클래스로 상속하자

public class StopWatchDemo {
	
	// 부모의 run 만 가지고 있으면 부모를 넣었을때 편하게 실행될 수 있다.
	// abstract class's polymorphism
	public void execute(StopWatch s) {
		s.run();
	}
	
	public static void main(String[] args) throws Exception {
		/*
		new StopWatchDemo().execute(new StopNanoWatch());
		new StopWatchDemo().execute(new StopMilliWatch());
		
		StopWatchDemo swd = new StopWatchDemo();
		StopNanoWatch s1 = new StopNanoWatch();
		swd.execute(s1);
		
		StopMilliWatch s2 = new StopMilliWatch();
		swd.execute(s2);
		*/
		
		new StopWatchDemo().execute((StopWatch) new StopNanoWatch());
		new StopWatchDemo().execute((StopWatch) new StopMilliWatch());
		new StopWatchDemo().execute((StopWatch) new StopMicroWatch());
		
		//new StopWatchDemo().execute((StopWatch) Class.forName("java_20191127.step5."+ new Scanner(System.in).next()).newInstance());
	}
}
