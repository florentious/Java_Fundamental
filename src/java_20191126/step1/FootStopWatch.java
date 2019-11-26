package java_20191126.step1;

// 요구사항 
// 1. 밀리 세컨드로 경과 시간을 만들어주세요.
// 2. 나노 세컨드로 경과 시간을 만들어주세요..



public class FootStopWatch {
	private long startTime;
	private long endTime;
	
	
	public double getElapsedMilliTime() {
		return (double)(endTime - startTime) / (double)1000;
	}

	public static void main(String[] args) {
		
		FootStopWatch f = new FootStopWatch();
		//1970년 1월1일부터 지금까지 시간을 밀리세컨드로 반환
		f.startTime = System.currentTimeMillis();
		
		for(long i=0; i < (long)(5*Math.pow(10, 9));i++) {
			
		}
		
		f.endTime = System.currentTimeMillis();
		
		double elapsedTime = f.getElapsedMilliTime();
		
		System.out.printf("경과 시간 : %.3f 초", elapsedTime);		
		
	}
}
