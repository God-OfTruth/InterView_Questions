package Leet_Code;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
		String rNum = String.valueOf(getReverse(x));
		String num = String.valueOf(x);
		if (num.length() != rNum.length()) return false;
		for (int i=0; i< num.length(); i++) if (num.charAt(i) != rNum.charAt(i)) return false;
		return true;
	}
	public static int getReverse(int x){
		int num = x;
		int remainder;
		int reversedNum = 0;
		while (num != 0) {
			remainder = num % 10;
			reversedNum = reversedNum * 10 + remainder;
			num /= 10;
		}
		return reversedNum;
	}
}
