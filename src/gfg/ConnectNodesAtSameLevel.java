package gfg;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
	public static void main(String[] args) {
		Node root = new Node(10, new Node(3, new Node(4), new Node(1)), new Node(5, null, new Node(2)));
		connect(root);
		System.out.println(root.left.nextRight.data);
	}

	public static void connect(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		Node temp = null;
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				Node prev = temp;
				temp = q.poll();
				if (i > 0) prev.nextRight = temp;
				if (temp.left != null) q.add(temp.left);
				if (temp.right != null) q.add(temp.right);
			}
			temp.nextRight = null;
		}
	}

	private static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
			nextRight = null;
		}

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
