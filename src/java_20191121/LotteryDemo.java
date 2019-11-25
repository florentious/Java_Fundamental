package java_20191121;

public class LotteryDemo {
	public static void main(String[] args) {
		//Math.random() 0~1 사이에 임의의 double형태의 실수값을 반환함
		
		int[] lotto = new int[7];
		
		//get random Number
		for (int i = 0; i < lotto.length; i++) {
			double random = Math.random();
			int temp = (int) (random*45)+1;
			
			//compare and change number
			/* 
			//while문으로 재작
			int j=-1;
			while(true) {
				j++;
				if(i ==j ){
					break;
				}else {
					if(temp == lotto[j]) {
						temp = (int)(Math.random()*45)+1;
						j=-1;
					}
										
				}
			}
			*/
			// 배열의 중복여부를 확인하는 변수
			boolean isExisted = false;
			// 배열의 중복여부를 확인
			for (int j = 0; j < i; j++) {
				if(temp == lotto[j]) {
					//추가연산안하도록 처리
					isExisted = true;
					break;
				}				
			}
			// 똑같은 값이 있는경우 증감을 하지 않도록 i--; 이후 숫자를 받아오는 과정부터 반복문을 돌려, 아니면 입력
			if(isExisted) {
				i--;
			}else{
				lotto[i] = temp;
			}
			
			
		}
		/*
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random()*45)+1;
			for (int j = 0; j < i; j++) {			// 중복확인하면 다음 쪽으로 진행하지 않음
				if(lotto[j] == lotto[i]) {
					i--;							// 중복되면 진행을 하지 않음
					break;
				}
				
			}
		}
		*/
		// bubble sort, but 보너스 숫자까지 설정하지 않을수 있도록 조심
		for (int i = 0; i < lotto.length-2; i++) {
			for (int j = 0; j < lotto.length -i-2; j++) {
				if(lotto[j] > lotto[j+1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
				
			}
		}
		
		
		for (int i : lotto) {
			System.out.print(i+ "\t");
		}
		
		
	}
}
