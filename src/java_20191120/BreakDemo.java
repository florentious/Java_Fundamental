package java_20191120;

public class BreakDemo {
	public static void main(String[] args) {
		int sum=0;
		
		for (int i = 0; i < 10 ; i++) {
			
			sum+= i;
			
			if(i==5) break;
		}
		
		System.out.println(sum);
		
		// 반복문에 이름을 붙여서 해당 반복문을 빠져나갈수 있다.
		//해당 반복문 위에 이름을 붙여서 설정하고  블록을 빠져나가는 방법을 잉용한다.
		outter : 
		for (int i = 2; i < 10; i++) {	
			for (int j = 1; j < 10; j++) {
				if(i==4 && j==9) break outter;
				System.out.printf("%d * %d = %d\n",i,j,i*j);
				
			}
			
		}
		
	}
}
