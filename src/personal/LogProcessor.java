package personal;

import java.io.*;

public class LogProcessor {

	public static void processLog(String inputFilename, String outputFilename) {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
			int count = 0;
			int sum = 0;
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length >= 10) {
					String request = parts[6] + " " + parts[7] + " " + parts[8];

					try {
						int bytesSent = Integer.parseInt(parts[parts.length - 1]);
						if (bytesSent > 5000) {
							count++;
							sum+= bytesSent;
						}
					} catch (NumberFormatException e) {
						System.out.println("Exception While Number Format : " + e.getMessage());
					}
				}
			}
			writer.write(count + "\n" + sum + "\n");
		} catch (IOException e) {
			System.out.println("Exception While File Read : " + e.getMessage());
		}
	}


	public static void main(String[] args) {
		String filename = "";
		String outputFilename = "bytes_" + new File(filename).getName();
		processLog(filename, outputFilename);
	}

}
