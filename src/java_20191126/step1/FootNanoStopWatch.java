package java_20191126.step1;

// 요구사항 
// 1. 밀리 세컨드로 경과 시간을 만들어주세요.
// 2. 나노 세컨드로 경과 시간을 만들어주세요..
// 3. 마이크로 세컨트로 경과 시간을 만들어주세요...



public class FootNanoStopWatch {
	private long startTime;
	private long endTime;
	
	private long startNanoTime;
	private long endNanoTime;
	
	public double getElapsedMilliTime() {
		return (double)(endTime - startTime) / (double)1000;
	}
	
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime) / (double)1000000000;
	}

	public static void main(String[] args) {
		
		FootNanoStopWatch f = new FootNanoStopWatch();
		//1970년 1월1일부터 지금까지 시간을 밀리세컨드로 반환
		//f.startTime = System.currentTimeMillis();
		f.startNanoTime = System.nanoTime();
		
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		
		//f.endTime = System.currentTimeMillis();
		f.endNanoTime = System.nanoTime();
		/*
		double elapsedTime = f.getElapsedMilliTime();		
		System.out.printf("경과 시간 : %.3f 초", elapsedTime);		
		*/
		double elapsedTime = f.getElapsedNanoTime();	
		System.out.printf("경과 시간 : %.9f 초", elapsedTime);
		
		
	}
}
