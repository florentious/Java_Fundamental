package hello;

import java.util.Scanner;

public class PractalArrayDisTest {
	
	public static void main(String[] args) {
		System.out.print("input > ");
		int n = new Scanner(System.in).nextInt();
		
		//get arraySize
		
		int size=0;
		while(Math.pow(size, 2) <= n){
			size++;
		}
		
		int[][] arr = new int[size][size];
		
		
		// get start('1') position
		int startX = 0;
		int startY = 0;
		
		if(size%2 ==0) {
			// size = odd
			startX = size/2;
			startY = size/2-1;
		} else {
			startX = size/2;
			startY = size/2;
		}
		
		//print
		
		int x = startX;
		int y = startY;
		
		int count = 1;
		int posCount = 0;
		
		//arr[startX][startY] = count;
		/*
		for (int i = 0; i < n; i++) {
			count++;
			
			arr[x][y] = count;
			
		}
		*/
		
		arr[x][y] = count;
		
		
		
		
		
		System.out.println("return : " + (Math.abs(startX-x)+Math.abs(startY-y)));
		
	}
}
