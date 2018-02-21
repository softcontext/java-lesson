package thread01;

public class TestMain6 {

	public void print(String flag, int tick) {
		System.out.print(flag + tick + " ");

		if (tick % 10 == 0) {
			System.out.println();
		} else if (tick % 7 == 0) {
			// 개발자가 스레드에 붙인 이름을 조회한다.
			Thread thread = Thread.currentThread();
			System.out.println(">>> " + thread.getName());
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

	public static void main(String[] args) {
		TestMain6 tm = new TestMain6();

		Thread thread1 = new Thread() {
			@Override
			public void run() {
				tm.count("A", 10);
			}
		};

		// 디버깅을 위해서 스레드의 이름을 붙인다.
		thread1.setName("Thread #1");
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				tm.count("B", 10);
			}
		});

		thread2.setName("Thread #2");
		thread2.start();

		Thread threadMain = Thread.currentThread();
		System.out.println(">>> " + threadMain.getName());
		System.out.println("Done.");
	}

}
