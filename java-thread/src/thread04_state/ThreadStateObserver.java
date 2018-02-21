package thread04_state;

public class ThreadStateObserver extends Thread {
	private Thread targetThread;
	
	public ThreadStateObserver(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		System.out.println("Thread State Observer started.");
		
		while (true) {
			// 스레드 상태를 조회한다.
			Thread.State state = targetThread.getState();
			System.out.println("Target Thread State = " + state);
			
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			
			if (state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				
			}
		}
		
		System.out.println("Thread State Observer stopped.");
	}
}
