package lambda1;

public class LambdaExample {
	private Runnable mRunnable = new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 30; i++) {
				System.out.print((i + 1) + " ");
				if ((i + 1) % 10 == 0) {
					System.out.println();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	};

	private Runnable mRunnable2 = () -> {
		for (int i = 0; i < 30; i++) {
			System.out.print((i + 1) + " ");
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	};

	public static void main(String[] args) {
		LambdaExample example = new LambdaExample();

		new Thread(example.mRunnable).start();
		new Thread(example.mRunnable2).start();
		new Thread(()->{
			for (int i = 0; i < 30; i++) {
				System.out.print((i + 1) + " ");
				if ((i + 1) % 10 == 0) {
					System.out.println();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}).start();
	}

}
