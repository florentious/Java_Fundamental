package java_20191119;

public class LiteralDemo {
	public static void main(String[] args) {
		//byte 범위를 넘어가면 overflow  발생
		//byte b1 = 128;
		
		int a1 = 128;		//10진수 표기법
		int a2 = 076;		//8진수 표기법
		int a3 = 0x123;		//16진수 표기법
		int a4 = 0b10101;	//2진수 표기법
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		//long literal은 숫자뒤에 l 또는 L 로 표기
		long l1 = 2200000l;
		
		//float literal은 소수점 뒤에 f 또는 F 로 표기
		float f1 = 123.43f;
		
		//double literal은 소수점 뒤에 d 또는 D로 표기. 소수점이 있을 시 생략이 가능함
		double d1 = 1234.56;
		
		//boolean 리터럴은 true 또는  false
		boolean isExisted = false;
		
		System.out.println(l1);
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(isExisted);
		
		a1 = 10;
		d1 = 10.0;
		//primitive data type의 ==연산자는 값만 비교함(결과는 boolean 값으로 나옴, datatype은 무시)
		System.out.println(a1==d1);
		
		int first = 10;
		int second = first;
		first = 20;
		
		System.out.println(first);
		System.out.println(second);
		
		
		
		
		
	}
}
