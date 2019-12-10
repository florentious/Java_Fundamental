package hello;

import java.util.Scanner;
import java.util.Stack;

public class StackExam {
	public static void main(String[] args) {
		
		String input = new Scanner(System.in).nextLine();
		
		char[] equation = new char[input.length()];
		
		for (int i = 0; i < equation.length; i++) {
			equation[i] = input.charAt(i);
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		/*
		for (int i = 0; i < equation.length; i++) {
			if( equation[i] == ' ') {
				// if input black, pass it
			}else if (String.valueOf(equation[i]).matches("[0-9]")) {
				stack.add(equation[i]);
			}else if (String.valueOf(equation[i]).matches("[/*-+]")) {
				stack.add(equation[i]);
			}else if (equation[i] == '(') {
				stack.add(equation[i]);
			}else if (equation[i] == ')') {
				// stack.pop()
				
				
			}
		}
		*/
		
		// infix -> postfix
		
	}
}
