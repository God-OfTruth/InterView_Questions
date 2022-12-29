package Leet_Code;

import java.util.*;

public class SingleThreadedCPU {
	public static void main(String[] args) {
		int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
		System.out.println(Arrays.toString(getOrder(tasks)));
	}

	public static int[] getOrder(int[][] tasks) {
		final int n = tasks.length;

		int[][] A = new int[n][3];

		for (int i = 0; i < n; ++i) {
			A[i][0] = tasks[i][0];
			A[i][1] = tasks[i][1];
			A[i][2] = i;
		}

		int[] ans = new int[n];
		int ansIndex = 0;
		Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.processTime == b.processTime ? a.index - b.index : a.processTime - b.processTime);
		int i = 0;
		long time = 0;

		Arrays.sort(A, Comparator.comparing(a -> a[0]));

		while (i < n || !minHeap.isEmpty()) {
			if (minHeap.isEmpty()) time = Math.max(time, A[i][0]);
			while (i < n && time >= (long) A[i][0]) {
				minHeap.offer(new T(A[i][1], A[i][2]));
				++i;
			}
			assert minHeap.peek() != null;
			final int processTime = minHeap.peek().processTime;
			final int index = Objects.requireNonNull(minHeap.poll()).index;
			time += processTime;
			ans[ansIndex++] = index;
		}

		return ans;
	}

	static class T {
		public int processTime;
		public int index;

		public T(int processTime, int index) {
			this.processTime = processTime;
			this.index = index;
		}
	}
}
