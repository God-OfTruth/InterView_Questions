package hacker_rank;

import java.util.*;

public class Solution {
	public static int calculateSum(ArrayList<Integer> a, int sum) {
		int ans = 0;
		Collections.sort(a);
		int n = a.size();
		int i = 0;
		int j = n - 1;
		while (i < j) {
			int currentSum = Math.abs(a.get(i) - a.get(j)) + Math.abs(a.get(i) + a.get(j));
			if (currentSum == sum) {
				ans++;
				int nexti = i + 1;
				while (nexti < j && Math.abs(a.get(nexti)) == Math.abs(a.get(i))) {
					nexti++;
					ans++;
				}
				int nextj = j - 1;
				while (nextj > i && Math.abs(a.get(j)) == Math.abs(a.get(nextj))) {
					nextj--;
					ans++;
				}
				i = nexti;
				j = nextj;
			} else if (currentSum < sum) {
				i++;
			} else {
				j--;
			}
		}
		HashMap<Integer, Integer> mp = new HashMap<>();
		for (int num : a) {
			if (sum % 2 == 1) continue;
			int half = sum / 2;
			if (mp.containsKey(half) && num == half) {
				ans += mp.get(half);
			}
			mp.put(num, mp.getOrDefault(num, 0) + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>(List.of(1, 1, 2, 0));
		System.out.println(calculateSum(integers, 2));
	}
}

