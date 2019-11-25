package java_20191120;

public class WhileDemo {
	public static void main(String[] args) {
		
		// while 합
		int sum=0, i=1;
		while(i<=100){
			sum+= i;
			i++;
		}
		System.out.printf("1부터 100까지의 합은 %,d 입니다.",sum);
		
		
		
		int first=2;
		
		while(first<10) {
			int second = 1;
			while (second<10) {
				System.out.printf("%d * %d = %d\n",first,second,first*second);
				second++;
			}
			
			first++;
			
				System.out.println("");
		}
		
	}
}
