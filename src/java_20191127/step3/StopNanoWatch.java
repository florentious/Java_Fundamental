package java_20191127.step3;

public class StopNanoWatch {

	long startTime;
	long endTime;
	
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
