package hello;

public class StaticArrayTest {
	public static void main(String[] args) {
		
		int input = 50;
		boolean check = true;
				
		int aL = 8;
		int[] a = new int[aL];
		int aCount = 0;
		
		for (int i = 2; i < input; i++) {
			for (int j = 0; j < aCount; j++) {
				if(aCount == aL) {
					aL *= 2;
					int[] temp = new int[aL];
					System.arraycopy(a, 0, temp, 0, aL/2);
					
					a = temp;
					
				}
				
				if(i % a[j] == 0) {
					check = false;
					break;
				}
				
			}
			
			if(check == true) {
				a[aCount] = i;
				aCount++;
			}
			check = true;
		}
		
		for (int i : a) {
			System.out.println(i);
		}
		
		
		
		
	}
}
