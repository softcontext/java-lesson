package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessExample {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long time = System.currentTimeMillis();
		Process process = null;
		try {
			/** 표준입출력 */
			process = rt.exec("notepad.exe");
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			/** 에러입출력 */
			InputStream standardError = process.getErrorStream(); // 에러스트림을 가져온다.
			InputStreamReader ow = new InputStreamReader(standardError); // 에러스트림을 읽어들인다
			BufferedReader errorReader = new BufferedReader(ow);// 버퍼로 읽어들인다.
			StringBuffer stderr = new StringBuffer();
			String lineErr = null;
			while ((lineErr = errorReader.readLine()) != null) {
				stderr.append(lineErr).append("\n");
			}
			// 에러데이타를 콘솔에 출력
			System.out.println(stderr.toString());

			int exitVal = process.waitFor();
			System.out.println("Process exited with " + exitVal);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Failed to execute: " + e.getMessage());
		} finally {
			if (process != null)
				process.destroy();
			System.out.println("경과시간  " + (System.currentTimeMillis() - time) + "ms");
		}
	}

}
