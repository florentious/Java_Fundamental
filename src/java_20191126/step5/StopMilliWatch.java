package java_20191126.step5;

public class StopMilliWatch extends StopWatch{
	//milli-timer
	private void start() {
		setStartTime(System.currentTimeMillis());
	}	
	private void stop() {
		setEndTime(System.currentTimeMillis());
	}
	
	private double getElapsedTime() {
		return (double)(getEndTime() - getStartTime()) / (double)1000;
	}
	
	public void run() {
		start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		stop();
		double elapsedTime = getElapsedTime();
		System.out.printf("경과 시간 : %.3f 초", elapsedTime);
	}
	
	
}
