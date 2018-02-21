package thread02_priority;

public class TestMain {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			// 스레드에 이름을 붙인다.
			Thread thread = new MyThread("Thread #" + (i + 1));
			
			if (i == 9) {
				// 10번째 스레드에 처리 우선순위를 최대치로 설정한다.
				thread.setPriority(Thread.MAX_PRIORITY);
			} else {
				thread.setPriority(Thread.MIN_PRIORITY);
			}
			
			thread.start();
		}
	}

}
