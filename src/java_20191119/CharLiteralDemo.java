package java_20191119;

public class CharLiteralDemo {
	public static void main(String[] args) {
		// 1. 유니코드 표현법 => '\u0000'
		char c1 = '\uC774';
		char c2 = '\uAD6C';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println('\uC774'+'\uAD6C');	// 문자형태 2개 합성하면 아스키코드 합산되어 나옴. 실행을 하기위해서는 아래와 같은 형태가 나와야됨
		System.out.println(""+c1+c2);			// 임의의 문자열을 상대로 char형 variable을  String형태로 변환해서 출력해야함
												// 그렇게 하지 않으면 오버로딩형태로 전환해야하나보다
		
		// 2. 아스키코드 표현법
		// 48-57 숫자, 65-90 영문 대문자, 97-122 영문 소문자
		
		char c4 = 97;
		System.out.println(c4);
		
		char c5 = 'a';
		char c6 = '성';
		
		System.out.println(c5);
		System.out.println(c6);
		
		// escape character
		// \n -> line feed, \t -> tab
		// \\ -> \, \" -> ", \' -> '
		System.out.println("hello\n" + "world");
		System.out.println("hello\t" + "world");
		
		String path = "C:\\dev\\workspace";
		System.out.println(path);
		
		
		
	}
}
