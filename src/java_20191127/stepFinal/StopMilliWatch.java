package java_20191127.stepFinal;

public class StopMilliWatch extends StopWatch{
	
	private void start() {
		setStartTime(System.currentTimeMillis());
	}
	private void stop() {
		setEndTime(System.currentTimeMillis());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		start();
		for(long i=0;i< (long)(Math.pow(10, 10));i++) {
			
		}
		stop();
		
		System.out.printf("경과시간 : %.3f",(double)(getEndTime()-getStartTime()) / (double)1000);
	}
	
}
