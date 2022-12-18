package Leet_Code;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
	public static void main(String[] args) {
		int[] temp = {30, 60, 90, 23};
		System.out.println(Arrays.toString(dailyTemperatures(temp)));
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = temperatures.length - 1; i >= 0; --i) {
			while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
