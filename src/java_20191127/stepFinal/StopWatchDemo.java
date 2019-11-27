package java_20191127.stepFinal;

public class StopWatchDemo {
	public void execute(StopWatch s) {
		s.run();
	}
	
	public static void main(String[] args) throws Exception {			// throws Exception 예외처리 안하면 안되는 이유
		//StopWatch s = (StopWatch) Class.forName("java_20191127.stepFinal." + args[0]).newInstance();
		new StopWatchDemo().execute((StopWatch)Class.forName("java_20191127.stepFinal." + args[0]).newInstance());
	}
}
