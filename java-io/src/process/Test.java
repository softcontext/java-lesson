package process;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class Test {

	/*
	 * http://d2.naver.com/helloworld/1113548
	 */
	public static void main(String[] args) {
		String[] command = {"cmd /c echo hello"};
		DefaultExecutor executor = new DefaultExecutor();
		CommandLine cmdLine = CommandLine.parse(command[0]);
		for (int i = 1, n = command.length; i < n; i++) {
			cmdLine.addArgument(command[i]);
		}
		
		try {
			executor.execute(cmdLine);
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
