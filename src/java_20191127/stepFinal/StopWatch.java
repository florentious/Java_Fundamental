package java_20191127.stepFinal;

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
	
	public abstract void run();
	
	
}
