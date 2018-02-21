package thread01;

public class TestMain3 {

	public static void print(String flag, int tick) {
		System.out.print(flag + tick + " ");

		if (tick % 10 == 0) {
			System.out.println();
		}
	}

	public static void count(String flag, int max) {
		for (int i = 0; i < max; i++) {
			print(flag, i + 1);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}

	public static void main(String[] args) {
		// 스레드는 개발자가 직접 생성하는 것이 아니고 자바가 대신 처리하는 방식이므로
		// start() 메소드를 호출하면 이 때 스레드가 생성되고 이 스레드가 run() 메소드를 기동한다.
		ExtendsThread thread1 = new ExtendsThread();
		thread1.start();

		// Runnable 인터페이스를 구현한 클래스는 start() 메소드가 없으므로 
		// new Thread(Runnable 인터페이스 구현객체) 코드로 
		// 스레드 객체의 생성자에 Runnable 인터페이스 구현객체를 전달하면
		// 스레드 객체는 자신의 run() 메소드를 기동하는 대신 
		// 생성자로 받은 Runnable 인터페이스 구현객체의 run() 메소드를 기동한다.
		ImplementsRunnable thread2 = new ImplementsRunnable();
		new Thread(thread2).start();
		
		System.out.println("Done.");
	}

	/*
	 * 스레드를 만드는 방법 2가지
	 */
	
	// #1
	// Thread 클래스를 상속한 클래스를 만들고 run() 메소드를 오버라이딩해서 
	// 새로 고용하는 스레드가 처리할 로직을 배치한다.
	// 클래스가 이미 다른 클래스를 상속하고 있다면 extends Thread를 못하므로
	// #2 방법을 사용해야 한다.
	public static class ExtendsThread extends Thread {
		@Override
		public void run() {
			count("A", 10);
		}
	}

	// #2
	// Runnable 인터페이스를 구현한 클래스를 만들고 run() 추상메소드를 구현해서
	// 새로 고용하는 스레드가 처리할 로직을 배치한다.
	public static class ImplementsRunnable implements Runnable {
		@Override
		public void run() {
			count("B", 10);
		}
	}
}
