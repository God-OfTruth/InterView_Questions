package leet_code;

public class MinimumDeletionSize {
	public static void main(String[] args) {
		String[] strings = {"a", "b"};
		System.out.println(minDeletionSize(strings));
	}

	public static int minDeletionSize(String[] strings) {
		int ans = 0;
		for (int j = 0; j < strings[0].length(); ++j)
			for (int i = 0; i + 1 < strings.length; ++i)
				if (strings[i].charAt(j) > strings[i + 1].charAt(j)) {
					++ans;
					break;
				}
		return ans;
	}
}
