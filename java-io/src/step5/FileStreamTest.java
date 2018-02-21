package step5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamTest {

	public static void main(String args[]) {

		try {
			byte numbers[] = { 11, 21, 3, 40, 5 };

			OutputStream fos = new FileOutputStream("./src/step5/test.txt");
			for (int i = 0; i < numbers.length; i++) {
				fos.write(numbers[i]); // 바이트로 저장한다.
			}
			fos.close();

			InputStream fis = new FileInputStream("./src/step5/test.txt");
			int size = fis.available();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				System.out.print((byte) fis.read() + "  ");
			}
			fis.close();
		} catch (IOException e) {
			System.out.print("Exception");
		}
	}

}
