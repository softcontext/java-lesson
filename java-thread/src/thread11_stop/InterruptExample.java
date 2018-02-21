package thread11_stop;

public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread1();
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		thread.interrupt();
	}

}
