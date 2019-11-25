package java_20191121;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		String[] fruits = { "apple", "banana", "watermelon", "peach" };

		String[] temp = new String[6];

		// 각 파라미터는 원본배열, 원본배열시작번호, 목적배열, 목적배열시작번호,복사 갯수
		System.arraycopy(fruits, 0, temp, 2, fruits.length);

		temp[0] = "blueberry";
		temp[1] = "rasberry";

		for (String fruit : temp) {
			System.out.println(fruit);
		}

		// reference쪽 복사는 참조값복사이기 때문에 위에 있는 원본값을 바꿈
		String[] ref = fruits;
		ref[0] = "jobs";

		System.out.println(fruits[0]);
		System.out.println(ref[0]);
		
		System.out.println();
		
		
		// reference 및 primitive
		/*
		 * String a="ab";
		 * String b="ab";
		 */

		String a = new String("ab");
		String b = new String("ab");

		System.out.println(a == b);

	}
}
