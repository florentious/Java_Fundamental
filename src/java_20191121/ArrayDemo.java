package java_20191121;

public class ArrayDemo {
	public static void main(String[] args) {
		//1. 배열선언
		int[] a = new int[4];
		
		//2. 배열 할당
		a[0]=1;
		a[1]=2;
		a[2]=3;
		a[3]=4;
		
		//3. 배열의 출력
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		// 1,2. 배열 생성과 할당을 동시에 설정
		int[] b = {1,2,3,4};
		//int[] b = new int[]{1,2,3,4};
		
		// 배열의 값 변경 재할당
		for (int i = 0; i < b.length; i++) {
			b[i] = (i+1)*100;
		}
		
		
		//enhanced for loop
		for (int i : b) {
			System.out.println(i);
		}
		
	}
}
