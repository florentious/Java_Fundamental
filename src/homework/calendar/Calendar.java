package homework.calendar;

import java.util.Scanner;

public class Calendar {
	private int year;
	private int month;
	private int day;
	
	private static final String[] dayOfWeek = {"일","월","화","수","목","금","토"};
		
	//check is Leap Year
	private static boolean isLeapYear(int year) {
		return (year%4)==0 && (year%100)!=0 || (year%400)==0;
	}
	// get month Array
	private static int getMonth(int year, int month) {
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		// check leap year
		if(isLeapYear(year)) {
			monthArray[1] = 29;
		}else {
			monthArray[1] = 28;
		}
		// return how many the month
		return monthArray[month-1];
	}
	
	private int dateToDay(int year, int month, int day) {
		int total = 0;
		
		// add pre-year to day
		total += (year-1)*365 + ((year-1)/4) - ((year-1)/100) + ((year-1)/400);
		
		// add pre-month to day
		for(int i=1;i<month;i++) {
			total += getMonth(year,i);
		}
		// add day
		total += day;
		
		return total;
	}
	
	// day to get day of week
	private String getDayOfWeek(int days) {
		return dayOfWeek[days%7];
	}
	
	private int startDay(int year, int month, int day) {
		return dateToDay(year,month,day)%7;
	}
	
	// start and print 
	public void start() {
		//int input = getDate();
		printDate(getDate());
	}
	private void printDate(int input) {
		switch(input) {
		case 1:
			print(this.year);
			break;
		case 2:
			print(this.year, this.month);
			break;
		case 3:
			print(this.year, this.month, this.day);
			break;
		default :
			System.err.println("input correct value");	
		}
		
		start();
	}
	// print year-calendar
	private void print(int year) {
		for(int i=1;i<=12;i++) {
			print(year,i);
		}
	}
	// print month-calendar
	private void print(int year, int month) {
		System.out.printf("\t   Year : %d, Month : %d\n\n", year, month);
		
		for(int i=0;i<dayOfWeek.length;i++) {
			System.out.printf(" %s\t",dayOfWeek[i]);
		}
		System.out.println();
		
		// print blank
		for(int i=0;i<startDay(year,month,1);i++) {
			System.out.printf("\t");
		}
		// print real days
		for(int i=1;i<=getMonth(year,month);i++) {
			System.out.printf("%2d\t",i);
			// use '\n' for 7days
			if((i+startDay(year,month,1))%7==0) {
				System.out.printf("\n");
			}
		}
		System.out.printf("\n\n");
		
	}
	// print get day of week
	private void print(int year, int month, int day) {
		System.out.printf(" %d 년  %d 월  %d 일 %s요일 입니다.\n",year,month,day,getDayOfWeek(dateToDay(year,month,day)));
	}
	
	private static String userUse(String input) {
		String[] ch ={" ","/","-"};
		int index = 0;
		
		for(int i=0;i<ch.length;i++) {
			if(input.contains(ch[i])) {
				index = i;
				break;
			}
		}
		// .으로 자르기엔 에러가 나고 배열에 가지고 있지 않기 떄문에 이렇게 따로 계산해서 처리한다.
		if(input.contains(".")) {
			return "\\.";
		}
				
		return ch[index];
		
	}
	
	// scanner
	public int getDate() {
		System.out.print("input : ");
		String input = new Scanner(System.in).nextLine();
		
		String[] date = input.split(userUse(input));
		
		
		switch(date.length) {
		case 3:
			day = Integer.parseInt(date[2]);
		case 2:
			month = Integer.parseInt(date[1]);
		case 1:
			year = Integer.parseInt(date[0]);
			break;
		default :
			System.out.println("err");			
		}
		
		// exeception => need to upgrade more
		if(month > 12 && month < 0) {
			System.err.println("month exeception");
		}else if(day > getMonth(year,month) && day < 0) {
			System.err.println("day exeception");
		}
		
		
		
		return date.length;
	}
	
	
}
