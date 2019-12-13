package hello;

public class ThreadDemoMain {
	
	public static void main(String[] args) {
		ThreadDemo t = new ThreadDemo();
		t.start();
		
		ThreadRunnableDemo r = new ThreadRunnableDemo();
		Thread th = new Thread(r);
		th.start();
		
		System.out.println();
	}
}
