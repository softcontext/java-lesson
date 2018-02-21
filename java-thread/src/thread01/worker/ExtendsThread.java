package thread01.worker;

public class ExtendsThread extends Thread {

	public void print(String flag, int tick) {
		System.out.print(flag + tick + " ");

		if (tick % 10 == 0) {
			System.out.println();
		}
	}

	public void count(String flag, int max) {
		for (int i = 0; i < max; i++) {
			print(flag, i + 1);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}

	@Override
	public void run() {
		count("A", 10);
	}

}
