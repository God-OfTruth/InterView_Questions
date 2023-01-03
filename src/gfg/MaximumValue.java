package gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumValue {
	public static void main(String[] args) {
		Node tree = new Node(4, new Node(9, new Node(3), new Node(5)), new Node(2, null, new Node(7)));
		for (int integer : maximumValue(tree)) {
			System.out.println(integer);
		}
	}

	static ArrayList<Integer> maximumValue(Node node) {
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int currLevelSize = queue.size();
			int max = Integer.MIN_VALUE;
			while (currLevelSize-- > 0) {
				Node curr = queue.remove();
				max = Math.max(max, curr.data);
				if (curr.left != null) queue.add(curr.left);
				if (curr.right != null) queue.add(curr.right);
			}
			list.add(max);
		}
		return list;
	}

	static class Node {
		final int data;
		final Node left;
		final Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
