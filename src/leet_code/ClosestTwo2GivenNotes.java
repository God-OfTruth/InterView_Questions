package leet_code;

public class ClosestTwo2GivenNotes {
	public static void main(String[] args) {
		int[] edges = {2, 2, 3, -1};
		int node1 = 0, node2 = 1;
		System.out.println(closestMeetingNode(edges, node1, node2));
	}

	public static int closestMeetingNode(int[] edges, int node1, int node2) {
		boolean[] n1Seen = new boolean[edges.length + 1];
		boolean[] n2Seen = new boolean[edges.length + 1];
		int n1Tracker = node1;
		int n2Tracker = node2;

		while (n1Tracker != -1 || n2Tracker != -1) {
			int result = Integer.MAX_VALUE;
			if (n1Tracker != -1) {
				if (n2Seen[n1Tracker + 1]) result = n1Tracker;
				n1Seen[n1Tracker + 1] = true;
				n1Tracker = edges[n1Tracker];
				if (n1Seen[n1Tracker + 1]) n1Tracker = -1;
			}
			if (n2Tracker != -1) {
				if (n1Seen[n2Tracker + 1]) result = Math.min(result, n2Tracker);
				n2Seen[n2Tracker + 1] = true;
				n2Tracker = edges[n2Tracker];
				if (n2Seen[n2Tracker + 1]) n2Tracker = -1;
			}
			if (result != Integer.MAX_VALUE) return result;
		}
		return -1;
	}
}
