package personal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodSubArrayChecker {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Read the length of the array
		int N = sc.nextInt();

		// Read the array A
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		// Read the value of K
		int K = sc.nextInt();

		// Read the number of queries
		int Q = sc.nextInt();

		long sumOfValidIndices = 0;

		// Process each query
		for (int i = 1; i <= Q; i++) {
			int I = sc.nextInt() - 1; // converting to 0-based index
			int r = sc.nextInt() - 1; // converting to 0-based index

			if (isGoodSubArray(A, I, r, K)) {
				sumOfValidIndices = (sumOfValidIndices + i) % MOD;
			}
		}

		// Print the result
		System.out.println(sumOfValidIndices);
	}

	private static boolean isGoodSubArray(int[] A, int I, int r, int K) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int j = I; j <= r; j++) {
			frequencyMap.put(A[j], frequencyMap.getOrDefault(A[j], 0) + 1);
		}

		for (int count : frequencyMap.values()) {
			if (count != K) {
				return false;
			}
		}

		return true;
	}
}
