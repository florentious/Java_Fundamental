package java_20191126.step3;

public class StopMilliWatch {
	private long startTime;
	private long endTime;
	
	//milli-timer
	public void start() {
		startTime = System.currentTimeMillis();	
	}	
	public void stop() {
		endTime = System.currentTimeMillis();
	}
	
	public double getElapsedTime() {
		return (double)(endTime - startTime) / (double)1000;
	}
	
}
