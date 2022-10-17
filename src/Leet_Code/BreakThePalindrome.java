package Leet_Code;

public class BreakThePalindrome {
    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
    }
    public static String breakPalindrome(String palindrome) {
        int l = palindrome.length();
        if (l == 1) {
            return "";
        }
        for (int i = 0; i < l; i++) {
            if (palindrome.charAt(i) != 'a' &&
                    (l % 2 == 0 || i != l / 2)) {
                return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, l - 1) + "b";
    }
}
