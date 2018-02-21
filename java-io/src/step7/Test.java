package step7;

import java.io.File;

public class Test {
	static FileManager fm = new FileManager();
	static File file = new File("./src/step7/hello.txt");
	static String writeContent = "Hello World!\nHello Java!";
	
	public static void main(String[] args) {
		fm.writeToFile(file, writeContent);
		
		//-----------------------------------------
		
		if (fm.exists(file)) {
			System.out.println("\"" + file.getPath() + "\" is exist.");
		}
		
		//-----------------------------------------
		
		String readContent = fm.readFileContent(file);
		System.out.println();
		System.out.println(readContent);
		
		//-----------------------------------------
		
		if(fm.remove(file)) {
			System.out.println("\"" + file.getPath() + "\" is deleted.");
		}
		
		//-----------------------------------------
		
		if (!fm.exists(file)) {
			System.out.println(file.getPath() + " is NOT exist.");
		}
	}

}
