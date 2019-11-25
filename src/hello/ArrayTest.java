package hello;

public class ArrayTest {
	static int[] insert(int[] arr, int i, int j) {

		int[] temp = new int[arr.length];
		
		System.arraycopy(arr, 0, temp, 0, j);
		temp[j] = arr[i];
		System.arraycopy(arr, j, temp, j+1, i-j);
		System.arraycopy(arr, i+1, temp, i+1, arr.length - (i+1));
		
		
		//arr = temp;
		
		return temp;
	}
	
	public static void main(String[] args) {
		
		int[] a = {9,6,5,7,1,5};
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<i;j++) {
				if(a[i] < a[j]) {
					a = insert(a,i,j);
					break;
				} 
			}
		}
		//print
		for (int index : a) {
			System.out.println(index);
		}
	}
}
