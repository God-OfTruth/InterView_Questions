package leet_code;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteTasks {
	public static void main(String[] args) {
		int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
		System.out.println(minimumRounds(tasks));
	}

	public static int minimumRounds(int[] tasks) {
		int rounds = 0;
		Map<Integer, Integer> count = new HashMap<>();
		for (int task : tasks) count.merge(task, 1, Integer::sum);
		for (int freq : count.values())
			if (freq == 1) return -1;
			else rounds += (freq + 2) / 3;
		return rounds;
	}
}
