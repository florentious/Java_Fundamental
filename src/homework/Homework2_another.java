package homework;

import java.util.Scanner;

public class Homework2_another {

	static void swapArray(char[] arr, int index1, int index2) {
		try {
			char temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// reverse String
		// 1. input : String "abcd" -> output "dcba"
		// 2. input : String "abcde" -> output "edcba"

		Scanner sc = new Scanner(System.in);

		System.out.print("2-1.reverse String ] input String : ");
		String input = sc.next();

		// String input = "abcd"; // 이후 "abcde"

		char[] ch = input.toCharArray();

		// 홀수나 짝수나 필요한 횟수는 동일함 홀수의 경우에는 중앙이라 어차피 움직이지 않음
		// 그래서 굳이 나눌 필요가 없음
		for (int i = 0; i < ch.length / 2; i++) {
			swapArray(ch, i, ch.length - 1 - i); // 스왑함수는 따로 메서드로 구현함
		}
		System.out.println(new String(ch)); // 출력
		

		// 1-100 까지 primeNumber get

		System.out.print("2-2. PrimeNumber ] input MaxNumber : ");
		int inputNumber = sc.nextInt();

		// Prime Number 확인용 identifier
		boolean checkPrime = true;

		// 번외
		// 만약에 프라임넘버를 배열로 각각 가지고 있다면, 연산속도는 상당히 줄어들것이다. 어차피 소수판별은 소수로 나눴을때 남는
		// 경우이기 때문이다.
		// 동적배열형태로 계속 만들기 위해서 배열의길이와 인덱스위치를 확인한다
		int arrayLength = 8;
		int[] primeNumber = new int[arrayLength];
		int aCount = 0;
		
		for (int i = 2; i <= inputNumber; i++) {
			for (int j = 0; j < aCount; j++) {
				// 만약 인덱스위치와 배열의 길이가 같다하면 배열의 사이즈를 2배로 늘려준다
				if(aCount == arrayLength) {
					arrayLength *= 2;
					int[] temp = new int[arrayLength];
					System.arraycopy(primeNumber, 0, temp, 0, arrayLength/2);
					primeNumber = temp;
				}
				// 본인 제외 나눠질시 소수판별을 그 '즉시' 종료한다
				if(i % primeNumber[j] == 0) {
					checkPrime = false;
					break;
				}
				
			}
			// 한바퀴가 돌고 소수판별이 되면 소수배열에 접어넣는다.
			if(checkPrime == true) {
				primeNumber[aCount] = i;
				aCount++;
			}
			checkPrime = true;
		}
		
		for (int i = 0; i < aCount; i++) {
			System.out.printf("%d\t", primeNumber[i]);
		}

	}
}
