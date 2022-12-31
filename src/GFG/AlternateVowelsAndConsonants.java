package GFG;

public class AlternateVowelsAndConsonants {
	public static void main(String[] args) {
		String s = "aeroplane";
		System.out.println(rearrange(s, s.length()));
	}

	public static String rearrange(String S, int N) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		int vowels = 0, consnt = 0;
		for (char ch : S.toCharArray())
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				arr1[ch - 'a']++;
				vowels++;
			} else {
				arr2[ch - 'a']++;
				consnt++;
			}
		if (Math.abs(vowels - consnt) > 1) return "-1";
		boolean flag = vowels >= consnt;
		int i = 0;
		int j = 0;
		StringBuilder ans = new StringBuilder();
		while (i < 26 && arr1[i] == 0) i++;
		while (j < 26 && arr2[j] == 0) j++;
		char ch1 = (char) (i + 'a');
		char ch2 = (char) (j + 'a');
		String str1 = "" + ch1 + "";
		String str2 = "" + ch2 + "";
		if (vowels == consnt && str1.compareTo(str2) > 0) flag = false;
		while (i < 26 && j < 26) {
			while (i < 26 && arr1[i] == 0) i++;
			while (j < 26 && arr2[j] == 0) j++;
			if (flag) {
				if (i < 26) {
					ans.append((char) (i + 'a'));
					arr1[i]--;
				}
				if (j < 26) {
					ans.append((char) (j + 'a'));
					arr2[j]--;
				}
			} else {
				if (j < 26) {
					ans.append((char) (j + 'a'));
					arr2[j]--;
				}
				if (i < 26) {
					ans.append((char) (i + 'a'));
					arr1[i]--;
				}
			}
		}
		return ans.toString();
	}
}
