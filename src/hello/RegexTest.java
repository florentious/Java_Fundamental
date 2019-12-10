package hello;

import java.util.Scanner;

public class RegexTest {

	public static void main(String[] args) {
		
		System.out.printf("input > ");
		String regex = new Scanner(System.in).nextLine();
		String checkString = "^[0-9]$";
		String checkString2 = "[+-/*()]";
		
		char[] stringChar = new char[regex.length()];
		
		
		boolean result = false;
		boolean result2 = false;
/*		
		if(regex.equals(checkString)) {
			result = true;
		}
		
		
*/		
		
		
		if(regex.matches(checkString)) {
			result = true;
		}
		
		if(regex.matches(checkString2)) {
			result2 = true;
		}
		
		
		
		System.out.println("check String 1 : " + result);
		System.out.println("check String 2 : " + result2);
		
		
	}
}
