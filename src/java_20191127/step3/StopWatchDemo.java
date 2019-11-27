package java_20191127.step3;


//1. distribute logic class and run class , 실제 비지니스 로직이 있는 클래스와 실행되는 클래스를 분리하자
//2. 시간을 측정하는 기능을 메서드로 추출

public class StopWatchDemo {
	public static void main(String[] args) {
		StopNanoWatch s = new StopNanoWatch();
		
		//f.startTime = System.currentTimeMillis();
		s.start();
		for (long i = 0;  i< (long)(1*Math.pow(10, 10)); i++) {
			
		}
		//f.endTime = System.currentTimeMillis();
		s.stop();
		
		// goto method
		//double elapsedTime = (double)(f.endTime - f.startTime) / (double)1000;
		//double elapsedTime = (double)(f.endNanoTime - f.startNanoTime) / (double)1000000000;
		
		
		//System.out.printf("경과 시간 : %.3f초\n",f.getElapsedTime());
		System.out.printf("경과 시간 : %.9f초\n",s.getElapsedTime());
	}
}
