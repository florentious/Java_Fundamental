package homework;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		// calendarDemo.java 복사 // 보기쉽게 하기위해서 클래스 이름 수정
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input (yyyy.mm.dd) : ");
		String input = sc.next();

		String yearString = input.substring(0, 4);
		String monthString = input.substring(5, 7);
		String dayString = input.substring(8);

		int year = Integer.parseInt(yearString);
		int month = Integer.parseInt(monthString);
		int day = Integer.parseInt(dayString);

		/*
		 * int year = 2019; int month = 12; int day = 25;
		 */

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String message = null;

		// 전년도까지의 일수 합산
		int yearToDay = 365 * (year - 1) + ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400);
		int monthToDay = 0;

		// 윤년판단변수 result
		boolean result = ((year%4)==0) && !(((year%100)==0) ^ ((year%400)==0));
		//booleaan result = ((year%4)==0) && ((year%100) !=0) || ((year%400)==0);

		//전원까지의 일수 합산  및 윤년 하루추가
		if(month >= 2 && result) {
			monthArray[1] = 29;
		}
		for (int i = 0; i < month - 1; i++) {
			monthToDay += monthArray[i];
		}

		switch ((yearToDay + monthToDay + day) % 7) {
		case 1:
			message = "월요일";
			break;
		case 2:
			message = "화요일";
			break;
		case 3:
			message = "수요일";
			break;
		case 4:
			message = "목요일";
			break;
		case 5:
			message = "금요일";
			break;
		case 6:
			message = "토요일";
			break;
		case 0:
			message = "일요일";
			break;
		default:
			message = "없음";
		}

		System.out.printf("%d년 %d월 %d일 %s 입니다.\n", year, month, day, message);

	}
}
