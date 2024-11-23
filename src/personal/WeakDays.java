package personal;

import java.util.*;

public class WeakDays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Day Number");
		String dayname;
		int dayNum;
		do {
			dayNum = sc.nextInt();
			dayname = switch (dayNum) {
				case 0 -> "Sunday";
				case 1 -> "monday";
				case 2 -> "tuesday";
				case 3 -> "wednesday";
				case 4 -> "thursday";
				case 5 -> "friday";
				case 6 -> "saturday";
				default -> "Invalid Day number";
			};
			System.out.println(dayname);
		} while (dayNum != 0);
	}
}
