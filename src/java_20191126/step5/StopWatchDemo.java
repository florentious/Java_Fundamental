package java_20191126.step5;

// main에는 logic 이들어가면 안됨
// 

public class StopWatchDemo {
	
	public static void execute(StopWatch s) {
		// 로직은 클래스에서 
		s.run();
	}
	
	public static void main(String[] args) throws Exception{
		/*
		StopWatch s1 = new StopNanoWatch();
		execute(s1);
		
		StopWatch s2 = new StopMilliWatch();
		execute(s2);
		
		StopWatch s3 = new StopMicroWatch();
		execute(s3);
		*/
		
		// argument를 스트링으로 받아서 그 스트링으로 새로운 객체로 생성.
		// 이때 새로운 클래스 이름엔 패키지명+클래스이름으로 새로운 해당 객체 생성
		// java reflection
		/*
		String input = "java_20191126.step5" + args[0];
		StopWatch s = (StopWatch) Class.forName(input).newInstance();
		*/
		// iniput arguments -> String으로 새로운 객체를 만들기
		StopWatch s = (StopWatch) Class.forName("java_20191126.step5." + args[0]).newInstance();
				
		execute(s);
				
	}
	
}
