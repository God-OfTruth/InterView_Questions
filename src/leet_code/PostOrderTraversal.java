package leet_code;

import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {
	public List<Integer> postorder(Node root) {
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Integer> res = new LinkedList<>();

		if(root == null) return res;
		stack.add(root);
		while(!stack.isEmpty()){
			Node node = stack.pollLast();
			res.addFirst(node.val);
			stack.addAll(node.children);
		}
		return res;
	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
