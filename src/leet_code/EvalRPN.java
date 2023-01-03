package leet_code;

import java.util.Stack;

public class EvalRPN {
	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			switch (s) {
				case "+" -> stack.push(stack.pop() + stack.pop());
				case "-" -> stack.push(-stack.pop() + stack.pop());
				case "*" -> stack.push(stack.pop() * stack.pop());
				case "/" -> {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a / b);
				}
				default -> stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}
}
