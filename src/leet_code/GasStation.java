package leet_code;

import java.util.Arrays;

public class GasStation {
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		final int gasses = Arrays.stream(gas).sum();
		final int costs = Arrays.stream(cost).sum();
		if (gasses - costs < 0) return -1;
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < gas.length; ++i) {
			sum += gas[i] - cost[i];
			if (sum < 0) {
				sum = 0;
				ans = i + 1;
			}
		}
		return ans;
	}
}
