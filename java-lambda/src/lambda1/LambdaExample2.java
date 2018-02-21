package lambda1;

public class LambdaExample2 {
	private String flag = "B";

	public class Inner implements Runnable {
		private String flag = "C";

		@Override
		public void run() {
			for (int i = 0; i < 30; i++) {
//				System.out.print(LambdaExample2.this.flag + (i + 1) + " ");
				System.out.print(this.flag + (i + 1) + " ");
				
				if ((i + 1) % 10 == 0) {
					System.out.println();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			private String flag = "A";

			@Override
			public void run() {
				for (int i = 0; i < 30; i++) {
					System.out.print(this.flag + (i + 1) + " ");
					
					if ((i + 1) % 10 == 0) {
						System.out.println();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();

		
		new Thread(new LambdaExample2().new Inner()).start();
	}

}
