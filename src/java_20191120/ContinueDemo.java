package java_20191120;

public class ContinueDemo {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 6)
				continue;
			// continue는 이하를 무시하고 다음 반복 및 평가로 넘어간다.
			// 즉 i=6에서는 sum+=i를 수행하지 않고 i=7로 넘어감
			sum += i;
		}

		System.out.println(sum);

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j == 6)
					continue;
				System.out.printf("%d * %d = %d\n", i, j, i * j);

			}

		}
		
		// break와 마찬가지로 해당 반복문에 평가/반복문으로 넘어간다
		outter : 
		for (int i = 2; i < 10; i++) {	
			for (int j = 1; j < 10; j++) {
				if(j==5) continue outter;
				System.out.printf("%d * %d = %d\n",i,j,i*j);
				
			}
			
		}
		
	}
}
