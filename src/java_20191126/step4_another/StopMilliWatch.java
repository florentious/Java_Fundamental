package java_20191126.step4_another;

public class StopMilliWatch extends StopWatch{
	
	@Override
	public void start() {
		super.setStartTime(System.currentTimeMillis());
	}
	@Override
	public void stop() {
		super.setEndTime(System.currentTimeMillis());
	}
	@Override
	public double elapsedTime() {
		return (double)(super.getEndTime() - super.getStartTime()) / (double)1000;
		
	}
	@Override
	public void print() {
		System.out.printf("경과 시간 : %.3f 초", elapsedTime());
		
	}
}
