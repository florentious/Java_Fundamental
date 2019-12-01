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
	private static int getMonth(int year, int month) throws Exception{
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
	
	private int dateToDay(int year, int month, int day) throws Exception{
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
	private String getDayOfWeek(int days) throws Exception{
		return dayOfWeek[days%7];
	}
	
	private int startDay(int year, int month, int day) throws Exception{
		return dateToDay(year,month,day)%7;
	}
	
	// start and print 
	public void start() throws Exception{
		//int input = getDate();
		printDate(getDate());
	}
	private void printDate(int input) throws Exception {
		
		try {
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
			}
			
		} catch (Exception e) {
			System.err.printf("\nPlease correct value\n");
		}  
		
		start();
	}
	// print year-calendar
	private void print(int year) throws Exception{
		for(int i=1;i<=12;i++) {
			print(year,i);
		}
	}
	// print month-calendar
	private void print(int year, int month) throws Exception{
		System.out.printf("\t   Year : %d, Month : %d\n\n", year, month);
		
		for(int i=0;i<dayOfWeek.length;i++) {
			System.out.printf(" %s\t",dayOfWeek[i]);
		}
		System.out.println();
		
		// print blank
		// int startDay = startDay(year,month,1); 반복문에 넣으면 과부하를 늘리는게 아닐까?, 질문이 필요한 순간이다
		for(int i=0;i<startDay(year,month,1);i++) {
			System.out.printf("\t");
		}
		// print real days
		// int getMonth = getMonth(year,month);  반복문에 너으면 강제로 과부하를 늘리는게 아닐까 변수 2개면 값만 저장하고 그 메서드를 안부를꺼같긴한데
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
	private void print(int year, int month, int day) throws Exception{
		System.out.printf(" %d 년  %d 월  %d 일 %s요일 입니다.\n",year,month,day,getDayOfWeek(dateToDay(year,month,day)));
	}
	
	// get 
	private static String userUse(String input) throws Exception{
		String[] ch ={" ","/","-"};
		int index = 0;
		
		for(int i=0;i<ch.length;i++) {
			if(input.contains(ch[i])) {
				index = i;
				break;
			}
		}
		// String.split으로는 . 이 먹지 않고 '\\.' 을 이용해야하나, 배열에는 '\\.' 형태로 들어가지 않음, 이방법인경우 직접리턴하게 됨
		if(input.contains(".")) {
			return "\\.";
		}
				
		return ch[index];
		
	}
	
	// scanner
	public int getDate() throws Exception{
		
		System.out.print("input : ");
		String input = new Scanner(System.in).nextLine().trim();
		String[] date = null;
		
		try {
			date = input.split(userUse(input));
			
			switch(date.length) {
			case 3:
				day = Integer.parseInt(date[2]);
			case 2:
				month = Integer.parseInt(date[1]);
			case 1:
				year = Integer.parseInt(date[0]);
				break;
			default :		
			}
			
		} catch (Exception e) {
			System.err.printf("\nPlease correct character ['/', '-', '.', ' ']");
			start();
		}
		
		return date.length;
	}
	
	
}
