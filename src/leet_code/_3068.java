package leet_code;

/**
 * There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.
 * Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:
 * Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
 * nums[u] = nums[u] XOR k
 * nums[v] = nums[v] XOR k
 * Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Example 1
 * Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
 * Output: 6
 * Explanation: Alice can achieve the maximum sum of 6 using a single operation:
 * - Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -> [2,2,2].
 * The total sum of values is 2 + 2 + 2 = 6.
 * It can be shown that 6 is the maximum achievable sum of values.
 */
public class _3068 {

	public static void main(String[] args) {
		System.out.println(maximumValueSum(new int[]{24, 78, 1, 97, 44}, 6, new int[][]{{0, 2}, {1, 2}, {4, 2}, {3, 4}}));
	}

	public static long maximumValueSum(int[] nums, int k, int[][] edges) {
		long maxSum = 0;
		int changedCount = 0;
		int minChangeDiff = Integer.MAX_VALUE;

		// Iterate over each number in nums
		for (final int num : nums) {
			// Calculate max sum by considering each number with or without XOR operation
			maxSum += Math.max(num, num ^ k);

			// Increment the changed count if the XOR operation results is a larger value
			if ((num ^ k) > num) {
				changedCount++;
			}

			// Calculate the minimum change difference
			minChangeDiff = Math.min(minChangeDiff, Math.abs(num - (num ^ k)));
		}

		// If the number of changes is even, return the maxSum as is
		if (changedCount % 2 == 0) {
			return maxSum;
		}

		// If the number of changes is odd, subtract the minimum change difference
		return maxSum - minChangeDiff;
	}

}
