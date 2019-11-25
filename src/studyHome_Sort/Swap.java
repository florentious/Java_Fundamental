package studyHome_Sort;

//Swap을 함수화 해서 쓰기위한 구실
public class Swap {
	public static void swap(int[] arr, int n1, int n2) {
		try {
			
			int temp = arr[n2];
			arr[n2] = arr[n1];
			arr[n1] = temp;

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
