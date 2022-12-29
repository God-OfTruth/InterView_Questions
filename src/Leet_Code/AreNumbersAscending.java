package Leet_Code;

public class AreNumbersAscending {
	public static void main(String[] args) {
		String s = "1 box has 3 blue 3 red 6 green and 12 yellow marbles";
		System.out.println(areNumbersAscending(s));
	}

	public static boolean areNumbersAscending(String s) {
		int pre = Integer.MIN_VALUE;
		for (String i : s.split(" "))
			try {
				int x = Integer.parseInt(i);
				if (x <= pre) return false;
				else pre = x;
			} catch (NumberFormatException e) {
				continue;
			}
		return true;
	}
}
