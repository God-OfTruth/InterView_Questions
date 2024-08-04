package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2196 {
	public static class TreeNode {
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

	public static void main(String[] args) {

	}

	public TreeNode createBinaryTree(int[][] descriptions) {
		Map<Integer, TreeNode> map = new HashMap<>();
		Set<Integer> children = new HashSet<>();
		for (int[] description : descriptions) {
			TreeNode parent = null;
			if (map.containsKey(description[0])) {
				parent = map.get(description[0]);
			} else {
				parent = new TreeNode(description[0]);
				map.put(description[0], parent);

			}
			TreeNode child = null;
			if (map.containsKey(description[1])) {
				child = map.get(description[1]);
			} else {
				child = new TreeNode(description[1]);
				map.put(description[1], child);
			}
			children.add(child.val);
			if (description[2] == 1) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
		for (int[] description : descriptions) {
			if (!children.contains(description[0])) {
				return map.get(description[0]);
			}
		}
		return null;
	}
}
