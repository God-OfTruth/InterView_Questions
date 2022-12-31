package GFG;

public class NoOfOpenDoors {
	public static void main(String[] args) {
		System.out.println(noOfOpenDoors(0x5L));
	}
	static int noOfOpenDoors(Long N) {
		return  (int) Math.sqrt(N);
	}
}
