package step1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	/*
	 * Byte Streams
	 * 스트림은 데이터의 흐름을 의미합니다. 바이트 단위로 처리합니다.
	 * 가장 많이 이용하는 클래스는 FileInputStream, FileOutputStream 클래스입니다.
	 * 바이너리 상태의 데이터를 처리하기에 적합합니다. 예: 이미지 처리
	 */
	public static void main(String args[]) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("src/step1/input.txt");
			out = new FileOutputStream("src/step1/output.txt");

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
