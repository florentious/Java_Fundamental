package java_20191127.step6;

public abstract class StopWatch {
	private long startTime;
	private long endTime;
	
	// encapsulation for member variable 
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
	// 비어있는 메서드는 만들지 않음
	// 추상을 하면 반드시 run에 subClass에 강제성을 붙일수 있음
	
	
}
