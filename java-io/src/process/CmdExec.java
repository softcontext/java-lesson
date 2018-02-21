package process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CmdExec {
	
	public CmdExec(String cmdline) {
		try {
			String line;
			Process p = Runtime.getRuntime().exec(cmdline);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void main(String argv[]) {
		new CmdExec("src/process/myprog.bat");
	}
}
