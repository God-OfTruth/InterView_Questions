package gfg;

public class PrimeList {
	static class Node {
		Node next;
		int val;

		public Node(int data) {
			this.val = data;
			this.next = null;
		}

		public Node(int data, Node next) {
			this.val = data;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(2, new Node(6, new Node(10)));
		Node ans = primeList(node);
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	static Node primeList(Node head) {
		for (Node temp = head; temp != null; temp = temp.next) {
			if (!isPrime(temp.val)) {
				int left = temp.val - 1;
				int right = temp.val + 1;
				while (!isPrime(left) && !isPrime(right)) {
					left--;
					right++;
				}
				if (isPrime(left)) temp.val = left;
				else temp.val = right;
			}
		}
		return head;
	}

	private static boolean isPrime(int val) {
		if (val <= 1) return false;
		for (int i = 2; i <= Math.sqrt(val); i++) if (val % i == 0) return false;
		return true;
	}


}
