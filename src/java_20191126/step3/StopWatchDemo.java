package java_20191126.step3;


public class StopWatchDemo {
	
	public static void main(String[] args) {
		StopNanoWatch s = new StopNanoWatch();
		
		s.start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		s.stop();
		double elapsedTime = s.getElapsedTime();
		System.out.printf("경과 시간 : %.9f 초", elapsedTime);
		
	}
	
}
