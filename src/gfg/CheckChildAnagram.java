package gfg;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheckChildAnagram {

	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		System.out.println(areAnagrams(root1, root2));
	}

	public static void addChild(Queue<Node> q, Node node) {
		if (node.left != null) q.add(node.left);
		if (node.right != null) q.add(node.right);
	}

	public static boolean checkLevel(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2) {
		if (q1.size() != q2.size()) return false;
		while (!q1.isEmpty()) {
			int n = q1.remove();
			int m = q2.remove();
			if (n != m) return false;
		}
		return true;
	}

	public static boolean levelTravel(Node node1, Node node2) {
		if (node1 == null || node2 == null) return false;
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();

		q1.add(node1);
		q2.add(node2);

		do {
			int n = q1.size();
			int m = q2.size();

			if (n != m) return false;

			PriorityQueue<Integer> nLevel = new PriorityQueue<>();
			PriorityQueue<Integer> mLevel = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				Node t1 = q1.remove();
				Node t2 = q2.remove();

				nLevel.add(t1.data);
				mLevel.add(t2.data);

				addChild(q1, t1);
				addChild(q2, t2);
			}
			if (!checkLevel(nLevel, mLevel)) return false;
		} while (!q1.isEmpty() || !q2.isEmpty());
		return true;
	}

	public static boolean areAnagrams(Node node1, Node node2) {
		return levelTravel(node1, node2);
	}
}

class Node {
	final int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}