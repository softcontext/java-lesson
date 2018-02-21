package step4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	public static void main(String args[]) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			File fileSource = new File("src/step1/input.txt");
			File fileTarget = new File("src/step4/output.txt");
			
			in = new FileInputStream(fileSource);
			out = new FileOutputStream(fileTarget);

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("Done.");
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
}
