package java_20191127.step1;

//. 요구사항  nano-second로 시간을 측정할 수 있는 애플리케이션을 만들어주세요


public class FootNanoStopWatch {
	long startTime;
	long endTime;
	
	long startNanoTime;
	long endNanoTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime) / (double)1000;
	}
	
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime) / (double)1000000000;
	}
	
	public static void main(String[] args) {
		FootNanoStopWatch f = new FootNanoStopWatch();
		
		//f.startTime = System.currentTimeMillis();
		f.startNanoTime = System.nanoTime();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		//f.endTime = System.currentTimeMillis();
		f.endNanoTime = System.nanoTime();
		
		// goto method
		//double elapsedTime = (double)(f.endTime - f.startTime) / (double)1000;
		//double elapsedTime = (double)(f.endNanoTime - f.startNanoTime) / (double)1000000000;
		
		
		//System.out.printf("경과 시간 : %.3f초\n",f.getElapsedTime());
		System.out.printf("경과 시간 : %.9f초\n",f.getElapsedNanoTime());
		
	}
}
