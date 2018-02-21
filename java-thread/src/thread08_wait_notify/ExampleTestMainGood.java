package thread08_wait_notify;

public class ExampleTestMainGood {

	/*
	 * 1. synchronized keyword is used for exclusive accessing.
	 * 2. To make a method synchronized, simply add the synchronized keyword to its declaration. 
	 * 	Then no two invocations of synchronized methods on the same object can interleave with each other.
	 * 3. Synchronized statements must specify the object that 
	 * 	provides the intrinsic lock. 
	 * 	When synchronized(this) is used, you have to avoid to synchronizing invocations of other objects' methods.
	 * 4. wait() tells the calling thread to give up the monitor 
	 * 	and go to sleep until some other thread enters the same monitor and calls notify( ).
	 * 5. notify() wakes up the first thread that called wait() on the same object.
	 */
	public static void main(String[] args) {
		Thread2 b = new Thread2();
		b.start();

		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// In the example above, an object, b, is synchronized. 
			// b completes the calculation before Main thread outputs its total value.
			System.out.println("Total is: " + b.total);
		}
		
		System.out.println("Done.");
	}
//	Waiting for b to complete...
//	Total is: 4950
//	Done.
}

class Thread2 extends Thread {
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