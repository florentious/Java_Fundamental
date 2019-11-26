package java_20191126.step5;

public class StopNanoWatch extends StopWatch{
	//nano-timer
	private void start() {
		setStartTime(System.nanoTime());
	}	
	private void stop() {
		setEndTime(System.nanoTime());
	}
	
	private double getElapsedTime() {
		return (double)(getEndTime() - getStartTime()) / (double)1000000000;
	}
	
	public void run() {
		start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		stop();
		double elapsedTime = getElapsedTime();
		System.out.printf("경과 시간 : %.9f 초", elapsedTime);
	}
}
