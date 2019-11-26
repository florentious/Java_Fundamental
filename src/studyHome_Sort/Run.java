package studyHome_Sort;

import java.util.Scanner;

//같은 폴더내에서는 땡겨써도 됨
//import studyHome_Sort.BubbleSortAscend;
//import studyHome_Sort.SelectSortAscend;

public class Run {
	private int size;
	private int arrSize;
	private int sortMethod;
	private int[] arr;
	private long startTime, endTime;
	
	
	void printIn() {
		// get Array Size;
		System.out.print("input array length and array size: ");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		arrSize = sc.nextInt();
		
		System.out.print("select sort method (1.bubble  2.select  3.insert) : " );
		sortMethod = sc.nextInt();
	}
	
	void getRandom() {
		arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*arrSize);
			for (int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	void printOut() {
		System.out.println("before Sort : ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		switch(sortMethod) {
		case 1 :
			//bubble Sort & check sortTime
			startTime = System.currentTimeMillis();
			BubbleSortAscend.bubbleSortAscend(arr);
			endTime = System.currentTimeMillis();
			System.out.println("After Sort (bubble) : ");
			for (int i : arr) {
				System.out.print(i + ", ");
			}
			System.out.println();
			System.out.println("sort time : " + (endTime - startTime) + " milli-sec");
			
			break;
			
		case 2 :
			//Select Sort & check sortTime
			startTime = System.currentTimeMillis();
			SelectSortAscend.selectSortAscend(arr);
			endTime = System.currentTimeMillis();
			System.out.println("After Sort (select) : ");
			for (int i : arr) {
				System.out.print(i + ", ");
			}
			System.out.println();
			System.out.println("sort time : " + (endTime - startTime) + " milli-sec");
			
			break;
			
		case 3: 
			//Insert Sort & check sortTime
			startTime = System.currentTimeMillis();
			arr = InsertSortAscend.insertSortAscend(arr);		// call by reference
			endTime = System.currentTimeMillis();
			System.out.println("After Sort (insert) : ");
			for (int i : arr) {
				System.out.print(i + ", ");
			}
			System.out.println();
			System.out.println("sort time : " + (endTime - startTime) + " milli-sec");
			
			break;
			
		default : 
			System.out.println("err");
		}
		
	}
	
	public static void main(String[] args) {
		// 간결하게
		Run run = new Run();
		run.printIn();
		run.getRandom();
		run.printOut();
				
		
	}
}
