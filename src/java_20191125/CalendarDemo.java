package java_20191125;

public class CalendarDemo {
	private int year;
	private int month;
	private int day;
	int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private int totalCount;

	public void set(int y,int m,int d) {
		this.year = y;
		this.month = m;
		this.day = d;
		this.totalCount = 0;
		/*
		year = y;
		month = m;
		day = d;
		*/
		
	}
	
	public boolean isLeapYear() {
		return (year%4==0) && (year%100!=0) || (year%400==0);
	}
	
	// totalCount 를 멤버변수로 잡으면 리턴값 및 파라미터가 굳이 필요하지 않음
	public void getTotalCount() {
		int yearToDay = 365 * (year - 1) + ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400);
		int monthToDay = 0;

		// 윤년판단변수 result
		boolean result = isLeapYear();

		//전원까지의 일수 합산  및 윤년 하루추가
		if(month >= 2 && result) {
			monthArray[1] = 29;
		}
		
		for (int i = 0; i < month - 1; i++) {

			monthToDay += monthArray[i];
		}
		
		totalCount =  yearToDay + monthToDay + day;
	}
	
	public void print() {
		
		String message = null;
		switch (totalCount % 7) {
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
	
	public static void main(String[] args) {
		// main 이 간결해야함. 추상화를 통해서 메소드로만 인식해야함
		CalendarDemo c = new CalendarDemo();
		c.set(2019,12,25);
		c.getTotalCount();
		c.print();
		
	}
	
	
	
	
}
