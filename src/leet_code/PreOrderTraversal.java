package leet_code;

import java.util.*;

public class PreOrderTraversal {
	public static void main(String[] args) {
		Node node = new Node(5, new ArrayList<>(List.of(new Node(3), new Node(5))));
		System.out.println(preorder(node));
	}

	public static List<Integer> preorder(Node root) {
		List<Integer> integers = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		if (root == null) return integers;
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			integers.add(node.val);
			if (Objects.nonNull(node.children)) {
				Collections.reverse(node.children);
				stack.addAll(node.children);
			}
		}
		return integers;
	}

	static class Node {
		public final int val;
		public List<Node> children;

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
