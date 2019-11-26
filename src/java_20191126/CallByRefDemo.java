package java_20191126;

public class CallByRefDemo {
	public static void change(int i, int[] j) {
		
		i = 20;
		j[3] = 400;
	}
	
	public static void main(String[] args) {
		int a =10;
		int[] b = {1,2,3,4};
		
		System.out.println(a + ", " + b[3]);
		CallByRefDemo.change(a,b);					// a=> call by value, b=> call by reference
													// 같은 클래스 내에서는 클래스 명 생략가능
		
		System.out.println(a + ", " + b[3]);		// a = 변화없음, b 변화 생김
		
		
		//reference 의 경우
		int[] c;
		//System.out.println(c);					// 메모리에 올라와 있지 않기에 출력하면 에러남
		c= new int[4];
		
		int[] d = null;
		System.out.println(d);						// 메모리에 올라와 있기때문에 출력해도 문제 없음
		d = new int[4];
		
		//primitive 도 마찬가지임
		int age;
		//System.out.println(age);
		//int t = age +20;							// 메모리에올라와 있지 않은 상태로 사용할수 없음
		age = 10;									// 이순간
		
		//
		
	}
}
