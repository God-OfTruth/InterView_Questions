package GFG;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
	public static void main(String[] args) {
		int[] asteroids = {3, 5, -3};
		System.out.println(Arrays.toString(asteroidCollision(asteroids.length, asteroids)));
	}

	public static int[] asteroidCollision(int N, int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++)
			if (stack.isEmpty() || asteroids[i] > 0) stack.push(asteroids[i]);
			else while (true) {
				int peak = stack.peek();
				if (peak < 0) {
					stack.push(asteroids[i]);
					break;
				} else if (peak == -asteroids[i]) {
					stack.pop();
					break;
				} else if (peak > -asteroids[i]) break;
				else {
					stack.pop();
					if (stack.isEmpty()) {
						stack.push(asteroids[i]);
						break;
					}
				}
			}
		int[] ans = new int[stack.size()];
		int i = 0;
		for (int ast : stack) ans[i++] = ast;
		return ans;
	}
}
