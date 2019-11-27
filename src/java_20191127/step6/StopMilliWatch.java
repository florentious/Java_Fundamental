package java_20191127.step6;

public class StopMilliWatch extends StopWatch{
	
	private void start() {
		//startTime = System.currentTimeMillis();
		setStartTime(System.currentTimeMillis());
	}
	private void stop() {
		//endTime = System.currentTimeMillis();
		setEndTime(System.currentTimeMillis());
	}
	
	private double getElapsedTime() {
		return (double)(getEndTime() - getStartTime()) / (double)1000;
	}
	
	public void run() {
		start();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		stop();
		
		System.out.printf("경과 시간 : %.3f초\n",getElapsedTime());
	}
}
