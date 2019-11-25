package java_20191120;

import java.util.Scanner;

public class ForDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("input : \n");
		int getNumber = sc.nextInt();
		
		//별개수 바꿔서
		for(int i=0;i<getNumber*2;i++) {
			if(i<getNumber) {
				for (int j = 0; j < getNumber-i; j++) {
					
					System.out.printf(" ");
				}
				for (int j = 0; j < i+1; j++) {			
					System.out.printf("* ");				
				}
				System.out.println("");
				
			}else {
				for (int j = 0; j < i-getNumber+2; j++) {
					System.out.printf(" ");
				}
				for (int j = 0; j < (2*getNumber-i)-1; j++) {			
					System.out.printf("* ");				
				}
				System.out.println("");
				
			}
			
			
		}
		
	}
}
