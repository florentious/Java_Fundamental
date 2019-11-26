package hello;

public class CallbyReferenceTest {
	public static void newArray(int[] input) {
		/*
		for(int i=0;i<input.length/2;i++) {
			int temp = input[i];
			input[i] = input[input.length-1-i];
			input[input.length-1-i] = temp;
		}
		*/
		
		
		int[] temp = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			temp[i] = input[input.length-1-i];
		}
		
		input = temp;
		
		// input은 main에 arr <= 영향을 주지 않는다.
		
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		newArray(arr);
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		
	}
}
