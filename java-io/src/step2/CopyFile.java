package step2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

	/*
	 * Character Streams
	 * 캐릭터 스트림은 2바이트 씩 처리합니다. 문자열을 처리하기에 적합합니다.
	 * 가장 많이 사용되는 클래스는 FileReader, FileWriter 클래스입니다.
	 * 캐릭터 스트림 클래스들은 내부적으로 FileInputStream, FileOutputStream 클래스들을 사용합니다.
	 */
	public static void main(String args[]) throws IOException {
		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("./src/step2/input.txt");
			out = new FileWriter("./src/step2/output.txt");

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
