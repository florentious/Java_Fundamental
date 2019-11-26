package java_20191126.step2;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		
		s.start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		s.stop();
		double elapsedTime = s.getElapsedMilliTime();
		System.out.printf("경과 시간 : %.3f 초", elapsedTime);
		
		
	}
}
