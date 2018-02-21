package step3;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {
	
	public static void main(String args[]) throws IOException {
		InputStreamReader isr = null;

		try {
			isr = new InputStreamReader(System.in);
			System.out.println("Enter characters, 'q' to quit.");
			char c;
			do {
				c = (char) isr.read();
				System.out.print(c);
			} while (c != 'q');
			System.out.println("\nBye.");
		} finally {
			if (isr != null) {
				isr.close();
			}
		}
	}
	
}
