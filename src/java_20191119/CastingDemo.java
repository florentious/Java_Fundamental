package java_20191119;

public class CastingDemo {
	public static void main(String[] args) {
		// overflow 발생하여 compile error 발생, 이후 캐스팅
		//byte b1 = 250;
		
		byte b1 = (byte) 129;		// circuit 발생, 절대 권장하지 않음
		System.out.println(b1);
		
		int i1 = (int) 125.35;		// cut 발생, 소수점 이하 버림
		System.out.println(i1);	
		
		double d1 = 124.5f;			// auto casting
		System.out.println(d1);
		
		byte b2 = 10;
		byte b3 = 20;
		// 산술연산자는 반환값이 int 이기 때문에 전체를 byte로 casting 해야 에러가 발생하지 않음. 혹은 새롭게 연산자를 오버로딩해야함
		byte b4 = (byte)(b2 + b3);
		System.out.println(b4);
		
		// java에서는 구분을 위해 천단위로 언더라인으로 구분해도 상관없음. 구분히 확실히 명확하게 되어있음.
		int a1 = 10_000_000;
		System.out.println(a1);
		
		
		
	}
}
