package personal;

import java.util.*;

public class TaskScheduling {
	public static void main(String[] args) {
		int n = 3;
		List<Integer> task_memory = List.of(1, 2, 5);
		List<Integer> task_type = List.of(1, 2, 3);
		int max_memory = 6;
		System.out.println(minTimeToProcess(n, task_memory, task_type, max_memory));
	}

	public static int minTimeToProcess(int n, List<Integer> task_memory, List<Integer> task_type, int max_memory) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(task_type.get(i), new PriorityQueue<>());
			map.get(task_type.get(i)).add(-task_memory.get(i));
		}

		int time = 0;
		while (!map.isEmpty()) {
			Iterator<Map.Entry<Integer, PriorityQueue<Integer>>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, PriorityQueue<Integer>> entry = iterator.next();
				PriorityQueue<Integer> queue = entry.getValue();
				int memory = -queue.poll();
				if (!queue.isEmpty() && memory - queue.peek() <= max_memory) {
					memory -= queue.poll();
				}
				if (queue.isEmpty()) {
					iterator.remove();
				}
				time++;
			}
		}
		return time;
	}
}
