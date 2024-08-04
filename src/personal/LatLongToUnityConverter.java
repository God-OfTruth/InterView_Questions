package personal;

public class LatLongToUnityConverter {

	// Earth radius in meters (approximate)
	private static final double EARTH_RADIUS = 6371000.0;

	public static double[] convertLatLongToUnity(double latitude, double longitude) {
		// Convert latitude and longitude to radians
		double latRad = Math.toRadians(latitude);
		double lonRad = Math.toRadians(longitude);

		// Calculate x and z coordinates relative to the origin
		double x = EARTH_RADIUS * Math.cos(latRad) * Math.cos(lonRad);
		double z = EARTH_RADIUS * Math.cos(latRad) * Math.sin(lonRad);

		// Return x and z coordinates
		return new double[]{x, z};
	}

	public static void main(String[] args) {
		// Example usage
		double latitude = 37.387492987529157;
		double longitude = -121.98888684163315;

		double[] unityCoords = convertLatLongToUnity(latitude, longitude);
		double unityX = unityCoords[0];
		double unityZ = unityCoords[1];

		System.out.println("Unity X Coordinate: " + unityX/1000000);
		System.out.println("Unity Z Coordinate: " + unityZ/1000000);
	}
}


