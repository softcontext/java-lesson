package thread06_wait_notify;

public class WaitNotifyExample {

	/*
	 * 두 개의 스레드 ThreadA, ThreadB 가 공유 객체 WorkObject 를 통해(notify --> wait) 번갈아 작업한다.
	 */
	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(sharedObject);
		ThreadB threadB = new ThreadB(sharedObject);
		
		threadA.start();
		threadB.start();
	}

}
