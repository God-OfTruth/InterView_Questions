package GFG;

@SuppressWarnings("ReassignedVariable")
public class SingleValuedSubTrees {
	public static void main(String[] args) {
		Node tree = new Node(5, new Node(4, new Node(4), new Node(4)), new Node(5, null, new Node(5)));
		System.out.println(singleValued(tree));
	}

	public static int singleValued(Node root) {
		return f(root)[1];
	}

	static int[] f(Node root) {
		int status = 0, value = 0;
		if (root.left == null && root.right == null) {
			status = 1;
			value = 1;
		} else if (root.left == null) {
			int[] v1 = f(root.right);
			value = v1[1];
			if (v1[0] == 1 && root.data == root.right.data) {
				status = 1;
				value++;
			}
		} else if (root.right == null) {
			int[] v1 = f(root.left);
			value = v1[1];
			if (v1[0] == 1 && root.data == root.left.data) {
				status = 1;
				value++;
			}
		} else {
			int[] v1 = f(root.left);
			int[] v2 = f(root.right);
			value = v1[1] + v2[1];
			if (v1[0] == 1 && v2[0] == 1 && root.data == root.right.data && root.data == root.left.data) {
				status = 1;
				value++;
			}
		}
		return new int[]{status, value};
	}

	static class Node {
		int data;
		Node left;
		Node right;

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
