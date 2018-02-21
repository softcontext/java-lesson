package thread09_stop;

public class PrintThread1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("Thread #1 running...");

			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {

			}
		}
		
		System.out.println("Thread #1 stoping...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		
		System.out.println("Thread #1 stopped.");
	}
}
