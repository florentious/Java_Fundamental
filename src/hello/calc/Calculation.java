package hello.calc;

import java.util.Scanner;

public class Calculation {
	private String input;
	
	public Calculation() {
		
	}
	public Calculation(String input) {
		this.input = input;
	}


	private void getInput() {
		System.out.print("input : ");
		input = new Scanner(System.in).nextLine();
		
	}
	
	private double calcBinary() {
		double result = 0;
		
		double front = Double.parseDouble(input.substring(0, input.indexOf("[^+-*/]")));
		double back = Double.parseDouble(input.substring(input.indexOf("[^+-*/]")));
		
		
		
		return result;
	}
	
	
	public static void run() {
		Calculation cal = new Calculation();
		while(true) {
			cal.getInput();
			System.out.println(cal.calcBinary());		
			
			
		}
		
		
	}
	
	
	
	
}
