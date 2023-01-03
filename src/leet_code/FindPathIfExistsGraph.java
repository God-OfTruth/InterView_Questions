package leet_code;

public class FindPathIfExistsGraph {
	private static int[] p;

	public static void main(String[] args) {
		int n = 3;
		int[][] edges = {{0, 0}, {1, 2}, {2, 1}};
		int source = 0;
		int destination = 2;
		System.out.println(validPath(n, edges, source, destination));
	}


	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		p = new int[n];
		for (int i = 0; i < n; i++) p[i] = i;
		for (int[] e : edges) p[find(e[0])] = find(e[1]);
		return find(source) == find(destination);
	}

	static int find(int x) {
		if (p[x] != x) p[x] = find(p[x]);
		return p[x];
	}
}
