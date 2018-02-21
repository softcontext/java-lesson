package thread12_daemon;

public class DaemonExample {

	public static void main(String[] args) {
		AutoSaveThread thread = new AutoSaveThread();
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Done.");
		// 메인 스레드가 종료되면 데몬 스레드도 같이 종료된다.
	}

}
