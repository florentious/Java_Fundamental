package hello;

public class ArrTest {
	
	
	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		
		int count = 0;
		
		int x = arr.length/2;
		int y = arr[arr.length/2].length/2;
		
		
		while(true) {
			count++;

			arr[x][y] = count;
			
		}
		
		
		
		
	}
}
