package java_20191127.step5;

public class StopMicroWatch extends StopWatch{
	
	public void start() {
		startTime = System.nanoTime();
	}
	public void stop() {
		endTime = System.nanoTime();
	}
	
	public double getElapsedTime() {
		return (double)(endTime - startTime) / (double)1000000000;
	}
	
	public void run() {
		start();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		stop();
		
		System.out.printf("경과 시간 : %.6f초\n",getElapsedTime());
	}
}
