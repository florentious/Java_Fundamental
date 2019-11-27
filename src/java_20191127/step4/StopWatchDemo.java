package java_20191127.step4;


// 1. 실제 비니지스 로직을 분리하자

public class StopWatchDemo {
	public void execute(StopNanoWatch s) {
		s.start();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		s.stop();
		
		System.out.printf("경과 시간 : %.9f초\n",s.getElapsedTime());
	}
	
	public void execute(StopMilliWatch s) {
		s.start();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		s.stop();
		
		System.out.printf("경과 시간 : %.3f초\n",s.getElapsedTime());
	}
	
	public static void main(String[] args) {
		new StopWatchDemo().execute(new StopNanoWatch());
		new StopWatchDemo().execute(new StopMilliWatch());
		/*
		StopWatchDemo swd = new StopWatchDemo();
		StopNanoWatch s1 = new StopNanoWatch();
		swd.execute(s1);
		
		StopMilliWatch s2 = new StopMilliWatch();
		swd.execute(s2);
		*/
	}
}
