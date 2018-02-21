package thread01;

public class TestMain5 {

	public void print(String flag, int tick) {
		System.out.print(flag + tick + " ");

		if (tick % 10 == 0) {
			System.out.println();
		}
	}

	public void count(String flag, int max) {
		for (int i = 0; i < max; i++) {
			print(flag, i + 1);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}

	public static void main(String[] args) {
		TestMain5 tm = new TestMain5();
		
		// Thread 클래스를 바로 상속한 Local Inner Anonymous 클래스를 사용한다.
		new Thread(){
			@Override
			public void run() {
				tm.count("A", 10);
			}
		}.start();
		
		// Runnable 인터페이스를 바로 구현한 Local Inner Anonymous 클래스를 만들고
		// Thread 클래스의 생성자에 전달하는 방법을 사용한다.
		new Thread(new Runnable() {
			@Override
			public void run() {
				tm.count("B", 10);
			}
		}).start();
		
		System.out.println("Done.");
	}

}
