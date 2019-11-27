package java_20191127.step6;

public class StopMicroWatch extends StopWatch{
	
	private void start() {
		//startTime = System.nanoTime();
		setStartTime(System.nanoTime());
	}
	private void stop() {
		//endTime = System.nanoTime();
		setEndTime(System.nanoTime());
	}
	
	private double getElapsedTime() {
		return (double)(getEndTime() - getStartTime()) / (double)1000000000;
	}
	
	public void run() {
		start();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		stop();
		
		System.out.printf("경과 시간 : %.6f초\n",getElapsedTime());
	}
}
