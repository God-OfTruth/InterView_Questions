package hacker_rank;

public class TimeConversion {
	public static void main(String[] args) {
		String s = "12:01:09PM";
		System.out.println(timeConversion(s));
	}

	public static String timeConversion(String s) {
		if (s.charAt(8) == 'P') {
			return convertPM(s.substring(0, 8));
		} else {
			return convertAM(s.substring(0, 8));
		}

	}

	private static String convertAM(String s) {
		int hour = Integer.parseInt(s.substring(0,2));
		return s.substring(0,8);
	}

	private static String convertPM(String s) {
		int hour = Integer.parseInt(s.substring(0, 2)) + 12;
		if (hour == 24) {
			hour = 0;
		}
		System.out.println(hour);
		return hour + s.substring(2);
	}
}
