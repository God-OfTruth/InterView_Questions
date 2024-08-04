package personal;

import java.util.Comparator;
import java.util.Arrays;

/**
 * @implNote The data analysts of Hacker land want to schedule some long-running tasks on remote servers optimally to minimize the cost of running them locally.
 * The analysts have two servers, a paid one and a free one. The free server can be used only if the paid server is occupied.
 * The ith task is expected to take timely units of time to complete and the cost of processing the task on the paid server is cost[i]. The task can be run on the free server only if some task is already running on the paid server. The cost of the free server is 0 and it can process any task in 1 unit of time.
 * Find the minimum cost to complete all the tasks if tasks are scheduled optimally.
 */

public class TaskScheduler {
	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static class PairComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.first != b.first) {
				return a.first - b.first;
			}
			return b.second - a.second;
		}
	}

	public static int getMinCost(int[] cost, int[] time) {
		int n = cost.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			pairs[i] = new Pair(cost[i], time[i]);
		}

		Arrays.sort(pairs, new PairComparator());

		int i = 0;
		int j = n - 1;
		int ans = 0;

		while (i <= j) {
			ans += pairs[i].first;
			j -= pairs[i].second;
			i++;
		}

		return ans;
	}


	public static void main(String[] args) {
		int[] cost = {2, 3, 4, 2}; // Example cost array
		int[] time = {1, 1, 1, 1}; // Example time array
		System.out.println(getMinCost(cost, time)); // Output: 4
	}
}


