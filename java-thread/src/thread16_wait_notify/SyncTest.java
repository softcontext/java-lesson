package thread16_wait_notify;

public class SyncTest {
	public static SyncStack syncStack = new SyncStack();

	public static void main(String[] args) {
		new PushRunnable('H').start();
		new PushRunnable('E').start();
		new PushRunnable('L').start();
		new PushRunnable('L').start();
		new PushRunnable('O').start();

		new PopRunnable().start();
		new PopRunnable().start();
		new PopRunnable().start();
		new PopRunnable().start();
		new PopRunnable().start();
		new PopRunnable().start(); // 대기상태

		try {
			Thread.sleep(3000);
			System.out.println("-------------");
		} catch (Exception e) {
		}

		new PushRunnable('!').start();
	}

}

class PopRunnable extends Thread {
	public void run() {
		SyncTest.syncStack.pop();
	}
}

class PushRunnable extends Thread {
	private char c;

	public PushRunnable(char c) {
		this.c = c;
	}

	public void run() {
		SyncTest.syncStack.push(c);
	}
}