package Leet_Code;

import java.util.*;

public class PreOrderTraversal {
	public static List<Integer> preorder(Node root) {
		List<Integer> integers = new ArrayList<>();
		Stack<Node> stack = new Stack<>();

		if (root == null) return integers;
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			integers.add(node.val);
			Collections.reverse(node.children);
			stack.addAll(node.children);
		}
		return integers;

	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	;
}
