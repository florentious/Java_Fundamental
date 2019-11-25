package studyHome_GenerateSsn;

import java.util.Scanner;

import studyHome_GenerateSsn.GenerateSsn;

public class Run {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		GenerateSsn genSsn = new GenerateSsn();

		// system.in break
		while (true) {
			System.out.print("how many want to get SSN (want to exit, input : 0): ");
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.printf("%s\n", genSsn.generateSsn());
			}

			if (n == 0)
				break;

		}
	}
}
