package java_20191127.step6;

public class StopNanoWatch extends StopWatch{
	
	private void start() {
		//startTime = System.nanoTime();
		setStartTime(System.nanoTime());	// 굳이 super 붙이 필요없다. super 보통 붙이는 것은 헷갈릴때 붙이는 것이다.
	}
	private void stop() {
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
		
		System.out.printf("경과 시간 : %.9f초\n",getElapsedTime());
	}
}
