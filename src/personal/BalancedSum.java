package personal;

public class BalancedSum {
	public static void main(String[] args) {
		System.out.println(isBalanced("arise"));
	}
	static int isBalanced(String word) {
		if (word.length() % 2 != 0) {
			return -1;
		}

		int leftSum = 0;
		int rightSum = 0;
		int mid = word.length() / 2;

		for (int i = 0; i < mid; i++) {
			leftSum += charValue(word.charAt(i));
			rightSum += charValue(word.charAt(mid + i));
		}

		if (leftSum == rightSum) {
			return 1;
		} else {
			return 0;
		}
	}
	static int charValue(char c) {
		return Character.toLowerCase(c) - 'a' + 1;
	}
}
