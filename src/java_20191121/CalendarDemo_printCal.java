package java_20191121;

import java.util.Scanner;

public class CalendarDemo_printCal {
	public static void main(String[] args) {
		// 요일 찾아내기
		/*
		 * 달력만들기 1. 1년1월1일은 월요일 2. 1년 365일, 윤년은 366일 -2월29일 3. 윤년은 4년마다 발생하고
		 * 그중에서 100배수는 제외하고 400의 배수는 제외하지 않음
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("input (yyyy.mm) : ");
		String input = sc.next();

		String yearString = input.substring(0, 4);
		String monthString = input.substring(5);

		int year = Integer.parseInt(yearString);
		int month = Integer.parseInt(monthString);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 전년도까지의 일수 합산
		int yearToDay = 365 * (year - 1) + ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400);

		// 윤년판단함수
		// 한줄로 가능 코딩할것
		/*
		boolean result = false;
		if ((year % 4) == 0) {
			if ((year % 100) == 0) {
				if ((year % 400) == 0) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = true;
			}
		} else {
			result = false;
		}
		*/
		//System.out.println(result);
		boolean result = ((year%4)==0) && !(((year%100)==0) ^ ((year%400)==0));
		//System.out.println(result);

		//올해 전원까지의 일수 합산
		int monthToDay = 0;
		//윤년인경우 하루 추가
		/*
		if (month > 2 && result) {
			monthToDay++;
		}
		*/
		if(month >= 2 && result) {
			monthArray[1] = 29;
		}
		
		for (int i = 0; i < month - 1; i++) {

			monthToDay += monthArray[i];
		}
		
		
		int startDay = (yearToDay + monthToDay + 1) % 7;
		
		String[] Days= {"일","월","화","수","목","금","토"};
		
		for (int i = 0; i < Days.length; i++) {
			System.out.printf(" %s\t",Days[i]);
		}
		System.out.println();
		
		int monthCount =1;
		month : 
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				/*
				//월별 요일 종료시 반복문 종료
				if(month == 1 || month ==3 || month ==5 || month ==7 || month ==8 || month ==10 || month ==12) {
					if(monthCount > 31) {
						break month;
					}
				}else if(month == 4 || month ==6 || month ==9 || month ==11) {
					if(monthCount > 30) {
						break month;
					}
				}else {
					//2월은 윤달판별해서 일수 조정
					if(result == true) {
						if(monthCount > 29) {
							break month;
						}
					}else {
						if(monthCount > 28) {
							break month;
						}
						
					}
				}
				*/
				//반복문 설정
				if(monthCount > monthArray[month-1]) {
					break month;
				}
				if(i==0 && j<startDay) {
					System.out.printf("  \t");
				}else {
					System.out.printf("%2d\t",monthCount++);					
				}
			}
			System.out.println();
			
		}

	}
}
