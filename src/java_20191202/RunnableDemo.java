package java_20191202;

public class RunnableDemo implements Runnable{

	//runnable 에서는 run이 abstract
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d\n",threadName,i);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("***************** start *******************");
		
		RunnableDemo r1 = new RunnableDemo();
		Thread t1 = new Thread(r1,"first thread");
		t1.start();
		
		RunnableDemo r2 = new RunnableDemo();
		Thread t2 = new Thread(r2,"second thread");
		t2.start();
		
		
		for (int i = 0; i < 1000; i++) {
			System.out.printf("main thread : %d\n",i);
		}
		
		System.out.println("****************** end ********************");
	}
	
	
	
}
