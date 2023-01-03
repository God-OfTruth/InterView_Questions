package leet_code;

import java.util.*;

public class KeysAndRooms {
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(List.of(1, 3));
		list.add(List.of(3, 0, 1));
		list.add(List.of(2));
		list.add(List.of(0));
		System.out.println(canVisitAllRooms(list));
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int size = rooms.size();
		boolean[] visited = new boolean[size];
		visited[0] = true;
		dfs(rooms, visited, 0);
		for (int i = 0; i < size; i++) if (!visited[i]) return false;
		return true;
	}

	static void dfs(List<List<Integer>> rooms, boolean[] visited, int start) {
		List<Integer> nums = rooms.get(start);
		for (int newStart : nums) {
			if (!visited[newStart]) {
				visited[newStart] = true;
				dfs(rooms, visited, newStart);
			}
		}
	}
}
