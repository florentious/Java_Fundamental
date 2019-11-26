package java_20191126.step2;

public class StopWatch {
	private long startTime;
	private long endTime;
	
	private long startNanoTime;
	private long endNanoTime;
	
	//milli-timer
	public void start() {
		startTime = System.currentTimeMillis();	
	}	
	public void stop() {
		endTime = System.currentTimeMillis();
	}
	
	public double getElapsedMilliTime() {
		return (double)(endTime - startTime) / (double)1000;
	}
	
	//nano-timer
	public void startNano() {
		startNanoTime = System.nanoTime();
	}
	public void endNano() {
		endNanoTime = System.nanoTime();
	}
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime) / (double)1000000000;
	}
	
	
}
