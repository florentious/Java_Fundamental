package java_20191127.step1;

//. 요구사항  milli-second로 시간을 측정할 수 있는 애플리케이션을 만들어주세요


public class FootStopWatch {
	long startTime;
	long endTime;
	
	public static void main(String[] args) {
		FootStopWatch f = new FootStopWatch();
		
		f.startTime = System.currentTimeMillis();
		
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		f.endTime = System.currentTimeMillis();
		
		double elapsedTime = (double)(f.endTime - f.startTime) / (double)1000;
		
		System.out.printf("경과 시간 : %.3f초\n",elapsedTime);
		
	}
}
