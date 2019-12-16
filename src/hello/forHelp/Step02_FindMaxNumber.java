package hello.forHelp;

public class Step02_FindMaxNumber {
	
	public int foundMax(int[] array) {
		// 최댓값을 반환 받아주세요
		int maxNumber=0;
		
		
		return maxNumber;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] array = new int[(int)(Math.random()*40+10)];
		//none of duplicate
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*(array.length*5));
			for (int j = 0; j < i; j++) {
				if(array[j] == array[i]) {
					i--;
					break;
				}
			}
		}
		//print
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("MaxNumber : " + new Step02_FindMaxNumber().foundMax(array));
		
	}
}
