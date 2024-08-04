package personal;

import java.util.*;

public class John {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Step 1: Parse the input
		int N = scanner.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}

		// Step 2: Preprocess the list
		int[] prefixNegatives = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixNegatives[i] = prefixNegatives[i - 1] + (numbers[i - 1] == -1 ? 1 : 0);
		}

		// Step 3: Handle queries
		int Q = scanner.nextInt();
		for (int q = 0; q < Q; q++) {
			int L = scanner.nextInt();
			int R = scanner.nextInt();

			// Step 4: Calculate the number of negative numbers within the range
			int negativesInRange = prefixNegatives[R] - prefixNegatives[L - 1];

			// Step 5: Determine if the product is negative or positive
			if (negativesInRange % 2 == 0) {
				System.out.println("Positive");
			} else {
				System.out.println("Negative");
			}
		}

		scanner.close();
	}
}
