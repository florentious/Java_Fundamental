package java_20191127.step5;

public abstract class StopWatch {
	long startTime;
	long endTime;
	
	public abstract void run();
	// 비어있는 메서드는 만들지 않음
	// 추상을 하면 반드시 run에 subClass에 강제성을 붙일수 있음
	
	
}
