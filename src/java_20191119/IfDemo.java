package java_20191119;

public class IfDemo {
	public static void main(String[] args) {
		//실행키  run configuration -> main class 확인 후 -> arguments 내에 program arguments 숫자 변경후 aply, Run
		// cmd 내에서 java_20191119.IfDemo 12(args[0]) 1998(args[1]) ... arguments 표현방법
		int month = Integer.parseInt(args[0]);	//이클립스 실행할떄 인자값 집어넣는 방법
		
		//int month = 12;
		
		String season = null;
		
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
		}
		
		System.out.println(month + "월은 " +season+"입니다.");
		
		
	}
}
