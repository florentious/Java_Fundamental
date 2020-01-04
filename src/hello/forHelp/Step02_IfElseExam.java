package hello.forHelp;

public class Step02_IfElseExam {
	public String[] solution(int[] input) {
		String[] result = null;
		/*
		10~50사이의 크기의 배열이 각각 1~100사이의 랜덤값이 들어있습니다. 이 배열이 인수로 들어옵니다.
		결과 를 각 값에 'A', 'B'로 출력해주세요
		
		1. 홀수는  A 입니다
		2. 짝수이면서 2~15 사이는 B 입니다.
		3. 짝수이면서 16~60 사이는 A입니다.
		4. 짝수이면서 60보다 크면 B입니다.
		
		이결과를 각각 저장해서 배열로 반환해주세요
		  
		예상 출력 결과
		35 = A
		4 = B
		
		*/
		
		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[(int)(Math.random()*40+10)];
		for(int i=0;i<array.length;i++) {
			array[i] = (int)(Math.random()*99+1);
		}
		String[] check = new Step02_IfElseExam().solution(array);
		for(int i=0;i<array.length;i++) {
			System.out.printf("%d = %s \n",array[i],check[i]);
		}
	}
}
