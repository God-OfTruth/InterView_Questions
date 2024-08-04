package personal;

public class ClassExample {
	public static void main(String[] args) {
		char c1 = 'a'; // declare and initialize a char variable
		char c2 = 'b';
		System.out.println(c1);
		System.out.println(c2);
		char c3 = (char) (c1 + 1);
		char c4 = (char) (c2 - 1);
		System.out.println(c3);
		System.out.println(c4);
		char c5 = '\"';
		char c6 = '\n';
		System.out.println(c5);
		System.out.println("Hello" + c6 + "World!");
	}
}
