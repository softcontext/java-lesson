package thread01;

import thread01.worker.ExtendsThread;
import thread01.worker.ImplementsRunnable;

public class TestMain4 {

	public static void main(String[] args) {
		ExtendsThread thread1 = new ExtendsThread();
		thread1.start();

		ImplementsRunnable thread2 = new ImplementsRunnable();
		new Thread(thread2).start();

		System.out.println("Done.");
	}

}
