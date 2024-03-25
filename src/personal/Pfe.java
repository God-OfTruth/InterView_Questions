package personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Pfe {
	public static void main(String[] args) {
		int n = 3;
		List<String> logs = Arrays.asList("0:start:0","1:start:3","1:end:6","2:start:8","2:end:10","2:end:12");

		List<Integer> result = exclusiveTime(n, logs);

		System.out.println(result);
	}
	public static List<Integer> exclusiveTime(int n, List<String> logs) {
		int[] exclusiveTimes = new int[n];
		Stack<Integer> stack = new Stack<>();
		int prevTime = 0;

		for (String log : logs) {
			String[] parts = log.split(":");
			int functionId = Integer.parseInt(parts[0]);
			String event = parts[1];
			int timestamp = Integer.parseInt(parts[2]);

			if (event.equals("start")) {
				if (!stack.isEmpty()) {
					exclusiveTimes[stack.peek()] += timestamp - prevTime;
				}
				stack.push(functionId);
				prevTime = timestamp;
			} else {
				exclusiveTimes[stack.pop()] += timestamp - prevTime + 1;
				prevTime = timestamp + 1;
			}
		}
		List<Integer> res = new ArrayList<>();
		Arrays.stream(exclusiveTimes).forEach(res::add);
		return res;
	}
}
