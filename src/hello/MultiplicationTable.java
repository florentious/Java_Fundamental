package hello;

import java.util.ArrayList;

public class MultiplicationTable {
	public static void main(String[] args) {
		/*
		for(int i = 2; i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.printf("%d * %d = %d",i,j,i*j);
			}
			System.out.println();
		}
		*/
		
		/*
		int i =2;
		int j =1;
		while(i<10) {
			j = 1;
			while(j<10) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
				j++;
			}
			System.out.println();
			i++;
		}
		*/
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i+10);
		}
		/*
		for (Integer i : list) {
			System.out.println(i.intValue());
		}
		*/
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
