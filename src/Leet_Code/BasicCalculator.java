package Leet_Code;

import java.util.Stack;

public class BasicCalculator {
	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));
	}

	public static int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		char[] chars = s.toCharArray();
		int rst = 0;
		int num = 0;
		int sign = 1;
		stack.push(sign);
		for (char aChar : chars)
			if (aChar >= '0' && aChar <= '9') num = num * 10 + (aChar - '0');
			else if (aChar == '+' || aChar == '-') {
				rst += sign * num;
				sign = stack.peek() * (aChar == '+' ? 1 : -1);
				num = 0;
			} else if (aChar == '(') stack.push(sign);
			else if (aChar == ')') stack.pop();
		rst += sign * num;
		return rst;
	}
}
