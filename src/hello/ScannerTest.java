package hello;

import java.util.Scanner;

public class ScannerTest {
	
	public static String useChar(String input) {
		String[] ch = {" ","/","-"};
		/*
		int[] indexCh = new int[ch.length];
		
		for(int i=0;i<indexCh.length-1;i++) {
			indexCh[i] = input.indexOf(ch[i]);
		}
		indexCh[3] = input.indexOf("\\.");
		
		System.out.println(indexCh[3]);
		
		int max = indexCh[0];
		int index =0;
		for(int i=1;i<indexCh.length;i++) {
			if(max < indexCh[i]) {
				max = indexCh[i];
				index = i;
			}
		}
		*/
		
		int index = 0;
		
		for(int i=0;i<ch.length;i++) {
			if(input.contains(ch[i])) {
				index = i;
				break;
			}
		}
		if(input.contains(".")) {
			return "\\.";
		}
		return ch[index];
	}
	
	public static void main(String[] args) {
		System.out.printf("input : ");
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine().trim();
		
		String ch = useChar(input);
		
		String[] date = input.split(ch);
		
		int[] change = new int[date.length];
		
		for(int i=0;i<change.length;i++) {
			change[i] = Integer.parseInt(date[i]);
		}
		
		for (int i : change) {
			System.out.println(i);
		}
		
	}
}
