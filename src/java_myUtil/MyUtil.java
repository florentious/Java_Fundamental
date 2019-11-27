package java_myUtil;


public class MyUtil {

	// swap overloading
	public static void swap(int[] input, int n1, int n2) {
		int temp = input[n2];
		input[n2] = input[n1];
		input[n1] = temp;
	}

	public static void swap(double[] input, int n1, int n2) {
		double temp = input[n2];
		input[n2] = input[n1];
		input[n1] = temp;
	}

	public static void swap(char[] input, int n1, int n2) {
		char temp = input[n2];
		input[n2] = input[n1];
		input[n1] = temp;
	}

	public void bubbleSort(int[] input, boolean isAscending) {
		if (isAscending) {
			for (int i = 0; i < input.length - 1; i++) {
				for (int j = 0; j < input.length - (i + 1); j++) {
					if (input[j] > input[j + 1]) {
						swap(input, j, j + 1);
					}
				}

			}

		} else {
			for (int i = 0; i < input.length - 1; i++) {
				for (int j = 0; j < input.length - (i + 1); j++) {
					if (input[j] < input[j + 1]) {
						swap(input, j, j + 1);
					}
				}
				
			}
			
		}
	}
	public void bubbleSort(double[] input, boolean isAscending) {
		if (isAscending) {
			for (int i = 0; i < input.length - 1; i++) {
				for (int j = 0; j < input.length - (i + 1); j++) {
					if (input[j] > input[j + 1]) {
						swap(input, j, j + 1);
					}
				}

			}

		} else {
			for (int i = 0; i < input.length - 1; i++) {
				for (int j = 0; j < input.length - (i + 1); j++) {
					if (input[j] < input[j + 1]) {
						swap(input, j, j + 1);
					}
				}
				
			}
			
		}
	}
	
	
	public void selectSort(int[] input, boolean isAscending) {
		if(isAscending) {
			for (int i = 0; i < input.length; i++) {
				int min = input[i];
				int minIndex = i;
				for (int j = i + 1; j < input.length; j++) {
					if (min > input[j]) {
						min = input[j];
						minIndex = j;
					}
					
				}
				swap(input, i, minIndex);
				
			}
			
		} else {
			for (int i = 0; i < input.length; i++) {
				int max = input[i];
				int maxIndex = i;
				for (int j = i + 1; j < input.length; j++) {
					if (max < input[j]) {
						max = input[j];
						maxIndex = j;
					}
					
				}
				swap(input, i, maxIndex);
				
			}
			
		}
		
	}
	
	public void selectSort(double[] input, boolean isAscending) {
		if(isAscending) {
			for (int i = 0; i < input.length; i++) {
				double min = input[i];
				int minIndex = i;
				for (int j = i + 1; j < input.length; j++) {
					if (min > input[j]) {
						min = input[j];
						minIndex = j;
					}
					
				}
				swap(input, i, minIndex);
				
			}
			
		} else {
			for (int i = 0; i < input.length; i++) {
				double max = input[i];
				int maxIndex = i;
				for (int j = i + 1; j < input.length; j++) {
					if (max < input[j]) {
						max = input[j];
						maxIndex = j;
					}
					
				}
				swap(input, i, maxIndex);
				
			}
			
		}
		
	}
	
	public static int[] insertSorted(int[] array, int index1, int index2) {
		
		// 임시로 선언해서 받아온다음 다시 array 변경
		int[] temp = new int[array.length];
		
		System.arraycopy(array, 0, temp, 0, index2);
		temp[index2] = array[index1];
		System.arraycopy(array, index2, temp, index2+1, index1 - index2);
		System.arraycopy(array, index1+1, temp, index1+1, array.length - (index1+1));
		
		return temp;
		
	}
	
	public static int[] insertSortAscend(int[] input) {
		
		// Insert Sort
		// 앞에서부터 한개씩 해당위치에 맞게 입력함
		// 위치에 넣은뒤 그 뒤에는 스왑으로 하나씩 옮겨줘야함
		// i -> 삽일할 값의 인덱스, j -> 그앞까지의 sort array
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				// compare Checked array
				if(input[i] < input[j]) {
					//어차피 i앞에는 sort된 배열이기때문에 작아지는지만 판단하면 된다.
					// 배열이 리스트 형식이 아니기 때문에 새로 배열을 만들거나 아니면 배열을 정렬해야함.
					// 이 경우에서는 배열명같은 것을 정리하는것이 필요함.
					
					// arrayCopy를 이용하여 밀어주는 경우
					input = insertSorted(input,i,j);
					break;
				} 
				
			}
			
		}
		
		return input;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
