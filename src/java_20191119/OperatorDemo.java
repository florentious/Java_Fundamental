package java_20191119;

public class OperatorDemo {
	public static void main(String[] args) {
		int a = 7, b = 20;
		int c = 0;
		double d = 0;
		
		c = a + b;
		System.out.println(c);
		
		c = a - b;
		System.out.println(c);
		
		c = a * b;
		System.out.println(c);
		
		d = b / a;
		System.out.println(d);
		
		d = (double)b / (double)a;
		System.out.println(d);
		
		c = b % a;
		System.out.println(c);
		
		a += b; 					// a = a + b; 이런식으로 하지 말것. 직관적이지 않음. 코딩스타일 변경하기

		int sum = 0;
		for(int i=0;i<100;i++) {
			sum += i+1;				// sum = sum + i+1; 이런식으로 하지 말고 요약해서쓸 것. 코딩스타일을 바뀌어서 할것
		}
		System.out.println(sum);
		
		a++;						// 현재 줄에서는 a++나 ++a나 상관없지만 ++위치에 따라서 해당 줄이 끝나고 연산할 것인지 해당줄 전에 연산할 것인지 선택함
		++a;
		
		System.out.println(c);
		
		
		//증가 후 대입
		a=20;
		c=++a;
		System.out.println(c);
		
		//대입 후 증가
		a=20;
		c=a++;
		System.out.println(c);
		
		a=10;
		b=20;
		
		boolean isSuccess = false;
		isSuccess = a>b;					//불린에서는 연산자 true와 false의 결과값만 리턴함
		System.out.println(isSuccess);
		
		isSuccess = a<b;
		System.out.println(isSuccess);
	
		isSuccess = a>=b;
		System.out.println(isSuccess);
		
		isSuccess = a<=b;
		System.out.println(isSuccess);
		
		isSuccess = a==b;
		System.out.println(isSuccess);
		
		isSuccess = a!=b;
		System.out.println(isSuccess);
		
		isSuccess = (a==b) && (++a==++b);	// short circuit 확인 문제
											// a && b => a 가 false 이면 b연산을 하지 않음(short circuit)
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);
		
		isSuccess = (a==b) || (++a==++b);	// a || b => a가 true 이면 b 연산을 하지 않음(short circuit)
		
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);
		
	}
}
