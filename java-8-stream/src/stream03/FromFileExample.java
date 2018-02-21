package stream03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileExample {

	/*
	 * 파일로부터 스트림 얻기
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Stream<String> stream;
		
		Path path = Paths.get("./download/text/data.txt");
		
		// 운영체제의 기본 문자셋
		stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out::println);
		
		System.out.println();
		
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		stream = br.lines();
		stream.forEach(System.out::println);
	}

}
