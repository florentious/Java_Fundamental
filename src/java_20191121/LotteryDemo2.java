package java_20191121;

public class LotteryDemo2 {
	public static void main(String[] args) {
		//Math.random() 0~1 사이에 임의의 double형태의 실수값을 반환함
		
		int[] lotto = new int[7];
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random()*45)+1;	
			for (int j = 0; j < i; j++) {			// 중복확인하면 다음 반복으로 진행하지 않음, 그래서 새로운 반복시에 새로운 값을 얻는다.
				if(lotto[j] == lotto[i]) {
					i--;							// 중복되면 진행을 하지 않음
					break;
				}
				
			}
		}
		
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
		
		
		for (int i=0;i<lotto.length;i++) {
			if(i == 6) {
				System.out.print("bouns- ");
			}
			System.out.print(lotto[i]+ "\t");
		}
		
		
	}
}
