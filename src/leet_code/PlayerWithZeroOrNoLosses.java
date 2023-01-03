package leet_code;

import java.util.*;

public class PlayerWithZeroOrNoLosses {
	public static void main(String[] args) {
		int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
		System.out.println(findWinners(matches));
	}

	private static class Match {
		int losses;
		int wins;

		Match(int wins, int losses) {
			this.losses = losses;
			this.wins = wins;
		}

		public void incrementLosses() {
			this.losses++;
		}

		public void incrementWins() {
			this.wins++;
		}
	}

	public static List<List<Integer>> findWinners(int[][] matches) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		res.add(new ArrayList<>());
		Map<Integer, Match> map = new TreeMap<>();
		for (int[] match : matches) {
			if (map.containsKey(match[0])) map.get(match[0]).incrementWins();
			else map.put(match[0], new Match(1, 0));
			if (map.containsKey(match[1])) map.get(match[1]).incrementLosses();
			else map.put(match[1], new Match(0, 1));
		}
		map.forEach((integer, match) -> {
			if (match.losses == 0) res.get(0).add(integer);
			else if (match.losses == 1) res.get(1).add(integer);
		});
		return res;
	}
}
