package step7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	void writeToFile(File file, String fileContent) {
		try {
			final FileWriter writer = new FileWriter(file);
			writer.write(fileContent);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String readFileContent(File file) {
		final StringBuilder fileContentBuilder = new StringBuilder();
		if (file.exists()) {
			String stringLine;
			try {
				final FileReader fileReader = new FileReader(file);
				final BufferedReader bufferedReader = new BufferedReader(fileReader);
				while ((stringLine = bufferedReader.readLine()) != null) {
					fileContentBuilder.append(stringLine).append("\n");
				}
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileContentBuilder.toString();
	}

	boolean exists(File file) {
		return file.exists();
	}
	
	boolean remove(File file) {
		boolean result = false;
		if (file.exists()) {
			result = file.delete();
		}
		return result;
	}

	boolean clearDirectory(File directory) {
		boolean result = false;
		if (directory.exists()) {
			for (File file : directory.listFiles()) {
				result = file.delete();
			}
		}
		return result;
	}

}
