package thread05_yield;

public class ThreadB extends Thread {

	public boolean running = true;
	public boolean working = true;
	
	@Override
	public void run() {
		while (running) {
			if (working) {
				System.out.println("ThreadB running...");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					
				}
			} else {
				Thread.yield();
			}
		}
		
		System.out.println("ThreadB done.");
	}

}
