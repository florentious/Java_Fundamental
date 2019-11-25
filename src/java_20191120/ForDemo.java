package java_20191120;

import java.util.Scanner;

public class ForDemo {
	public static void main(String[] args) {
		String str = "hello";
		int a1 = 10;
		int a2 = 20;
		double d1 = 12.4567;
		
		System.out.printf("%10s , %d , %d , %.4f %n",str,a1, a2, d1);		//개행시 \n, %n 둘다 가능 소수점 이하에서는 반올림도 해줌
		System.out.println(str + " , " + a1 + " , " +a2+ " , " +d1);			//일반적인 c에 기능과 마찬가지 기능이 존재함. 기존 println에서는 불가능함
		
		int sum = 0;
		int bySum = 0;
		//걸린시간 확인하기 각 시간을 받와와서 받기
		// System.currentTimeMillis() => 1970년 1월1일기준으로 이후 흐른시간을 밀리초로 받아옴
		long start = System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			sum += i;			// debug mod 확인하기
			if (i%2 == 0) {
				bySum += i;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("경과시간 : " + (end-start)/1000 + "초");
		System.out.printf("sum : %d\n", sum);
		System.out.printf("bySum : %d\n",bySum);
		
		
		// 구구단
		/*
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
			System.out.println("");
		}
		
		for(int i=9;i>1;i--) {
			for(int j=1;j<10;j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
			System.out.println("");
		}
		*/
		
		// * tree 만들기
		Scanner sc = new Scanner(System.in);
		System.out.printf("input : \n");
		int getNumber = sc.nextInt();
		
		for(int i=0;i<getNumber*2;i++) {
			if(i<getNumber) {
				for (int j = 0; j < getNumber-i; j++) {
					
					System.out.printf(" ");
				}
				for (int j = 0; j < 2*i+1; j++) {			
					System.out.printf("*");				
				}
				System.out.println("");
				
			}else {
				for (int j = 0; j < i-getNumber+2; j++) {
					System.out.printf(" ");
				}
				for (int j = 0; j < 2*(2*getNumber-i)-3; j++) {			
					System.out.printf("*");				
				}
				System.out.println("");
				
			}
			
			
		}
		
		
	}
}


