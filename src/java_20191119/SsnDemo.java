package java_20191119;
//import java.util.Random;

public class SsnDemo {
	public static void main(String[] args) {
		int a1=1, a2=1, a3=1, a4=1, a5=1, a6=1;
		int b1=1, b2=1, b3=1, b4=1, b5=1, b6=1, b7=8;
		
		/*
		 요구사항
		 1. 각자리수를 2부터 9까지 곱하고, 다시 2-5까지 곱해서 합을 구함
		 2. 총합을 11로 나눈 나머지를 구한다.
		 3. 11에서 나눈 나머지를 뺀다.
		 4. 3의 결과를 10으로 나눈 나머지를 구한다.
		 5. 4의 결과와 맨마지막 숫자가 같으면 "정상적인 주민번호"
		    그렇지 않으면 "비정상적인 주민번호" 메세지를 출력
		*/
		
		int sum =0;
		int checkNum=0;
		sum = (a1*2+a2*3+a3*4+a4*5+a5*6+a6*7) + (b1*8+b2*9+b3*2+b4*3+b5*4+b6*5);
		checkNum = sum%11;
		if(b7 == (11-checkNum)%10) {
			System.out.println("정상정인 주민번호");
		}else if(b7 != (11-checkNum)%10) {
			System.out.println("비정상적인 주민번호");
		}else {
			System.out.println("주민번호가 아닙니다.");
		}
		
		
		// array type, check correct SSN
		int[] first = {1,1,1,1,1,1};
		int[] second = {1,1,1,1,1,1,8};
		
		int arrSum=0;
		
		//get arrSum
		//first arrSum
		for(int i=0;i<6;i++){
			arrSum+=first[i]*(i+2);
		}
		//second arrSum
		for(int i=0;i<6;i++) {
			/*
			if((i+8) > 9) {
				arrSum+=second[i]*(i);
			} else {
				arrSum+=second[i]*(i+8);
			}
			*/
			arrSum += ((i+8) > 9) ? (second[i]*i) : (second[i]*(i+8));
			
		}
		//get rest & check second last Number
		int rest= arrSum % 11;
		if(second[6] == (11-rest)%10) {
			System.out.println("정상정인 주민번호");
		}else {
			System.out.println("비정상적인 주민번호");
		}
		
		//번외 문자열로 들어올시에 확인방법
		String ssd="111111-1111118";
		int newSum=0,newCheckNum=0;
		
		String a = ssd.substring(0,6);
		String b = ssd.substring(7);
		
		int aNum = Integer.parseInt(a);
		int bNum = Integer.parseInt(b);
		
		newSum = (aNum/100_000)*2 + ((aNum/10_000)%10)*3 + ((aNum/1000)%10)*4 + ((aNum/100)%10)*5 + ((aNum/10)%10)*6 + (aNum%10)*7 + (bNum/1000_000)*8 + ((bNum/100_000)%10)*9+((bNum/10_000)%10)*2+((bNum/1000)%10)*3+((bNum/100)%10)*4+((bNum/10)%10)*5;
		newCheckNum = newSum%11;
		if((bNum%10) == (11-newCheckNum)%10) {
			System.out.println("정상정인 주민번호");
		}else if((bNum%10) != (11-newCheckNum)%10) {
			System.out.println("비정상적인 주민번호");
		}else {
			System.out.println("주민번호가 아닙니다.");
		}
		
		//주민번호 생성기 조건에 년도당 윤년계산해서 365 or 366일을 랜덤으로 돌리고 그로 앞자리 맞추고, 년도는 00-19까지는 3,4가 가능하게 5는 전체 가능 이후 랜덤돌리고 최종 계산값이 마지막글자
		//andom rand = new Random();
		//System.out.println(rand.nextInt(100));
		
	}
}
