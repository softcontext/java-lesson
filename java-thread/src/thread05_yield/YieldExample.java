package thread05_yield;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();

		threadA.start();
		threadB.start();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		// working 변수가 false가 되면 다른 스레드에게 스스로 양보한다.
		// 양보하다가 필요하면 다시 일을 스스로 시작할 수 있다.
		threadA.working = false;
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		threadA.working = true;
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		threadA.running = false;
		threadB.running = false;
	}
	
}
