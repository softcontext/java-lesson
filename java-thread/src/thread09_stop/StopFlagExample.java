package thread09_stop;

public class StopFlagExample {

	/*
	 * 스레드의 실행을 실행 중 언제라도 중지시키기 위해서 불린 플래그를 사용한다.
	 */
	public static void main(String[] args) {
		PrintThread1 pt = new PrintThread1();
		pt.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

		// 스레드를 중지시키기 위해서 불린 플래그를 변경한다.
		pt.setStop(true);
	}

}
