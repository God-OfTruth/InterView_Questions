package gfg;

public class NodeWithMaximumGCD {
	static Node node = new Node(-1);
	public static void main(String[] args) {
		Node node = new Node(4,
				new Node(5),
				new Node(2, new Node(3,
						new Node(6), new Node(12)),
						new Node(1)));
		System.out.println(maxGCD(node));
	}

	static int maxGCD(Node root) {
		if (root == null) return 0;
		if (root.left == null || root.right == null) return 0;

		int gcd = gcd(root.left.data, root.right.data);
		if (node.data > gcd) node = root;
		return Math.max(maxGCD(root.left), maxGCD(root.right));
	}

	private static int gcd(int x, int y) {
		if (y == 0) return x;
		else return gcd(y, x % y);
	}

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			this.data = item;
			this.left = right = null;
		}

		Node(int item, Node left, Node right) {
			this.data = item;
			this.left = left;
			this.right = right;
		}
	}
}
