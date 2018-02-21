package step6;

import java.io.File;

public class ManageDir {

	public static void main(String args[]) {
		File file = new File("./src/step6/temp");

		if (!file.exists()) {
			file.mkdirs();
			System.out.println("Create directory.");
		}

		//--------------------------------
		
		file = new File("./src/step6");
		
		String[] paths = file.list();
		System.out.println("size = " + paths.length);
		
		for (String path : paths) {
			System.out.println(path);
		}
		
		System.out.println("--------------------------------");
		
		File[] files = file.listFiles();
		
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.print("Dir : ");
			} else {
				System.out.print("File: ");
			}
			System.out.println(f.getName());
		}
	}

}
