package studyHome_Sort;

//import studyHome_Sort.Swap;

public class SelectSortAscend {
	public static void selectSortAscend(int[] input) {

		for (int i = 0; i < input.length; i++) {
			int min = input[i];
			int minIndex = i;
			for (int j = i + 1; j < input.length; j++) {
				if (min > input[j]) {
					min = input[j];
					minIndex = j;
				}

			}
			Swap.swap(input, i, minIndex);

		}

	}
}
