package java_20191126.step4_another;

public abstract class StopWatch {
	private long startTime;
	private long endTime;
	
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public abstract void start();
	public abstract void stop();
	public abstract double elapsedTime();
	public abstract void print();

}
