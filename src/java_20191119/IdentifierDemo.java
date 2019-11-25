package java_20191119;

//class명의 첫 글자는 대문자
// 두 단어가 합친 경우에는 두번째 단어의 첫글자는 대문자로 사용 - camel case
public class IdentifierDemo {
	public static void main(String[] args) {
		int age = 10;
		String name = "hello";
		
		//첫글자는 숫자를 사용할 수 없음.
		//String 1father = "John";
		
		//공백을 사용 할 수 없음.
		//String mother Name = "michell";
		
		//예약어는 사용 할 수 없음.
		//String void = "empty";
		
		//자바에서의 문자는 2Byte 문자이기 때문에 유니코드를 의미한다. 그래서 세계 모든 문자를 사용 할 수 있음.
		String 이름 = "Florentious";
		
		System.out.println(이름);
	}
	
}
