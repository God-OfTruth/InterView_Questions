package Leet_Code;

import java.util.*;

public class PossibleBipartition {
	public static void main(String[] args) {
		int n = 4;
		int[][] dislikes = {{4, 2}, {2, 3}, {1, 4}};
		System.out.println(possibleBipartition(n, dislikes));
	}

	//	1, 2
//	2, 3, 4
	public static boolean possibleBipartition(int n, int[][] dislikes) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] dislike : dislikes) {
			List<Integer> temp = graph.containsKey(dislike[0]) ? graph.get(dislike[0]) : new ArrayList<>();
			temp.add(dislike[1]);
			graph.put(dislike[0], temp);
			temp = graph.containsKey(dislike[1]) ? graph.get(dislike[1]) : new ArrayList<>();
			temp.add(dislike[0]);
			graph.put(dislike[1], temp);
		}
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				queue.offer(i);
				while (!queue.isEmpty()) {
					int cur = queue.poll();
					List<Integer> temp = graph.get(cur);
					if (temp == null) continue;
					for (Integer next : temp) {
						if (visited[next] == visited[cur]) return false;
						if (visited[next] == 0) {
							visited[next] = -visited[cur];
							queue.offer(next);
						}
					}
				}
			}
		}
		return true;
	}
}
