package java_20191126.step4;

// main에는 logic 이들어가면 안됨
// 

public class StopWatchDemo {
	
	public static void execute(StopNanoWatch s) {

		s.start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		s.stop();
		double elapsedTime = s.getElapsedTime();
		System.out.printf("경과 시간 : %.9f 초", elapsedTime);
	}
	public static void execute(StopMilliWatch s) {
		
		s.start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		s.stop();
		double elapsedTime = s.getElapsedTime();
		System.out.printf("경과 시간 : %.3f 초", elapsedTime);
	}
	
	public static void main(String[] args) {
		StopNanoWatch s = new StopNanoWatch();
		//StopMilliWatch s = new StopMilliWatch();
		execute(s);
		
		
	}
	
}
