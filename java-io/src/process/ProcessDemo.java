package process;

import java.io.InputStream;

public class ProcessDemo {
	public static void main(String[] args) {
		
		try {
			// create a new process
			Process p = Runtime.getRuntime().exec("notepad.exe");

			// get the input stream of the process and print it
			InputStream in = p.getInputStream();
			
			System.out.println(in.available());
			for (int i = 0; i < in.available(); i++) {
				System.out.println(in.read());
			}

			// wait for 10 seconds and then destroy the process
			Thread.sleep(5000);
			p.destroy();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
