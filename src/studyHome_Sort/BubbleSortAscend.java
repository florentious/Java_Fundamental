package studyHome_Sort;

//import studyHome_Sort.Swap;

public class BubbleSortAscend {
	public static void bubbleSortAscend(int[] input) {
		// bubble sort -> 양옆의 숫자를 비교해서 정렬함, 배열의 가장 마지막부분부터 정렬이 완료됨
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = 0; j < input.length - (i + 1); j++) {
				if (input[j] > input[j + 1]) {
					Swap.swap(input, j, j + 1);
				}
			}

		}

	}
}
