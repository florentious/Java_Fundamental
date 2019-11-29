package java_20191129;

public class ReturnDemo {
	public void m() {
		int a = 10;
		int b = 20;
		int c = a+b;
		
		if(c==30) {
			return;
		}
		
		System.out.printf("a + b = %d",c);
	}
	
	
	public static void main(String[] args) {
		int a = 10;
		int b = a;
		int c = a+b;
		
		new ReturnDemo().m();
		
		if(c == 20) {
			return;
		}
		System.out.println(c);
	}
}
