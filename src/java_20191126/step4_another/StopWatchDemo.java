package java_20191126.step4_another;

public class StopWatchDemo {
	public static void execute(StopWatch s) {
		s.start();
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		s.stop();
		s.print();
	}
	
	public static void main(String[] args) {
		StopWatch s = new StopNanoWatch();
		
		execute(s);
		
	}
}
