package GFG;

public class NumberOfIslands {
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '1', '0'}, {'0', '0', '1', '0', '0'}, {'1', '1', '0', '0', '0'}}));
		System.out.println(numIslandsIn8Directions(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '1', '0'}, {'0', '0', '1', '0', '0'}, {'1', '1', '0', '0', '0'}}));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == '1') {
					count++;
					countIslands(grid, i, j);
				}
		return count;
	}

	public static int numIslandsIn8Directions(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == '1') {
					count++;
					countIslandsInAllDirections(grid, i, j);
				}
		return count;
	}

	private static void countIslands(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
		grid[i][j] = '0';
		countIslands(grid, i, j + 1);
		countIslands(grid, i, j - 1);
		countIslands(grid, i - 1, j);
		countIslands(grid, i + 1, j);
	}

	private static void countIslandsInAllDirections(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
		grid[i][j] = '0';
		countIslands(grid, i, j + 1);
		countIslands(grid, i, j - 1);
		countIslands(grid, i - 1, j);
		countIslands(grid, i + 1, j);
		countIslands(grid, i + 1, j + 1);
		countIslands(grid, i - 1, j - 1);
		countIslands(grid, i - 1, j + 1);
		countIslands(grid, i + 1, j - 1);
	}
}
