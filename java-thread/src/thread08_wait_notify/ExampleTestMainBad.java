package thread08_wait_notify;

public class ExampleTestMainBad {

	public static void main(String[] args) {
		Thread1 b = new Thread1();
		b.start();

		System.out.println("Total is: " + b.total);
		System.out.println("Done.");
	}

//	Total is: 0
//	Done.
	
// The result would be 0. Because sum is not finished before it is used.
}

class Thread1 extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				total += i;
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
			}
			notify();
		}
	}
}