package java_20191126.step4_another;

public class StopNanoWatch extends StopWatch{

	@Override
	public void start() {
		super.setStartTime(System.nanoTime());
	}
	@Override
	public void stop() {
		super.setEndTime(System.nanoTime());
	}
	@Override
	public double elapsedTime() {
		return (double)(super.getEndTime() - super.getStartTime()) / (double)1000000000;
		
	}
	@Override
	public void print() {
		System.out.printf("경과 시간 : %.9f 초", elapsedTime());
		
	}
}
