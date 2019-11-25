package java_20191120;

import java.util.Scanner;


public class SwitchDemo {
	public static void main(String[] args) {
		
		//int month = Integer.parseInt(args[0]);	//이클립스 실행할떄 인자값 집어넣는 방법
		
		
		Scanner sc = new Scanner(System.in);
		
		//system.input 활용
		System.out.print("input month : " );
		int month = sc.nextInt();
		
		//int month = 12;
		
		String season = null;
		/*
		if(month==12 || month==1 || month==2) {
			season = "겨울";
		}else if(month==3 || month==4|| month==5) {
			season = "봄";
		}else if(month==6 || month==7|| month==8) {
			season = "여름";
		}else if(month==9 || month==10|| month==11) {
			season = "가을";
		}else {
			season = "없는 계절";
		}*/
		
		//switch 계절문
		// 어차피 3개단위 범위이므로 break;가 없으니 아래쪽가서 실행되는 결과임
		switch (month) {
			case 12: //season = "겨울";break;
			case 1 : //season = "겨울";break;
			case 2 : season = "겨울";break;
			case 3 : //season = "봄";break;
			case 4 : //season = "봄";break;
			case 5 : season = "봄";break;
			case 6 : //season = "여름";break;
			case 7 : //season = "여름";break;
			case 8 : season = "여름";break;
			case 9 : //season = "가을";break;
			case 10: //season = "가을";break;
			case 11: season = "가을";break;
			default : season = "없는 계절";
		
		}
		
		System.out.println(month + "월은 " +season+"입니다.");
		
		
	}
}
