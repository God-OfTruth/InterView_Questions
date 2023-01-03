package leet_code;

import java.util.PriorityQueue;

public class MinStoneSum {
	public static void main(String[] args) {
		int[] piles = {4, 3, 6, 7};
		int k = 3;
		System.out.println(minStoneSum(piles, k));
	}

	public static int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i : piles) pq.add(i);
		while (k > 0 && !pq.isEmpty()) {
			int temp = pq.poll();
			//noinspection IntegerDivisionInFloatingPointContext
			temp -= (int) Math.floor(temp / 2);
			pq.add(temp);
			k--;
		}
		int sum = 0;
		while (!pq.isEmpty()) sum += pq.poll();
		return sum;
	}
}
