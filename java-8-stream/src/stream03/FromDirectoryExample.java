package stream03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryExample {

	/*
	 * 디렉토리로부터 스트림 얻기
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Stream<Path> stream;
		
		Path path = Paths.get("./download/text/");
		
		stream = Files.list(path);
		stream.forEach(p -> System.out.println(p.getFileName()));
		
	}

}
