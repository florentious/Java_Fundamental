package hello;

public class SwapTest {

	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		
		for (int i = 0; i < input.length/2; i++) {
			int temp = input[i];
			input[i] = input[(input.length-1)-i];
			input[(input.length-1)-i] = temp;
		}
		
		for (int i : input) {
			System.out.println(i);
		}
		
		
	}
}
