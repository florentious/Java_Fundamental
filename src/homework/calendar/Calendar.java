package homework.calendar;

import java.util.Scanner;

public class Calendar {
	private int year;
	private int month;
	private int day;
	
	private int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public Calendar() {
		
	}
	
	public Calendar(int year) {
		this.year = year;
	}
	
	public Calendar(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	public Calendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		
	}

	private boolean isLeapYear(int year) {
		return (year%4)==0 && (year%100)!=0 || (year%400)==0;
	}
	
	public void run() {
		
	}
	
	public void getDate() {
		System.out.print("input : ");
		String input = new Scanner(System.in).next();
		
		//find '/' or '.' or '-'
		
	}
	
	
}
