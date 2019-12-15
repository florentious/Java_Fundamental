package hello.helpHim;

public class FindMaxNumber {
	
	public int foundMax(int[] array) {
		
		// 최댓값을 반환 받아주세요
		int maxNumber=0;
		
		
		return maxNumber;
		
	}
	
	
	public static void main(String[] args) {
		
		int size = (int)(Math.random()*40+10);
		int[] array = new int[size];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*(size*5));
			for (int j = 0; j < i; j++) {
				if(array[j] == array[i]) {
					i--;
					break;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println(new FindMaxNumber().foundMax(array));
		
	}
}
