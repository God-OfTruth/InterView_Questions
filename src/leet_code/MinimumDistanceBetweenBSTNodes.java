package leet_code;

public class MinimumDistanceBetweenBSTNodes {
	private static int ans = Integer.MAX_VALUE;
	private static int prev = Integer.MAX_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
		System.out.println(minDiffInBST(root));
	}

	public static int minDiffInBST(TreeNode root) {
		inorder(root);
		return ans;
	}

	private static void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		if (prev != Integer.MAX_VALUE) ans = Math.min(ans, root.val - prev);
		prev = root.val;
		inorder(root.right);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
