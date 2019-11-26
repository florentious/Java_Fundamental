package java_20191126.step4;

public class StopNanoWatch {
	private long startTime;
	private long endTime;
	
	//nano-timer
	public void start() {
		startTime = System.nanoTime();
	}	
	public void stop() {
		endTime = System.nanoTime();
	}
	
	public double getElapsedTime() {
		return (double)(endTime - startTime) / (double)1000000000;
	}
}
