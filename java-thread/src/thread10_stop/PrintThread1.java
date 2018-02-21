package thread10_stop;

public class PrintThread1 extends Thread {
	private boolean stop;

//	public void setStop(boolean stop) {
//		this.stop = stop;
//	}

	@Override
	public void run() {
		// 불린 플래그를 사용하지 않고 메인 스레드에서 thread.interrupt(); 코드를 사용하여 
		// 강제로 예외를 발생시켜 스레드를 멈춘다.
		while (!stop) {
			System.out.println("Thread #1 running...");

			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				stop = true;
			}
		}
		
		System.out.println("Thread #1 stoping...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		
		System.out.println("Thread #1 stopped.");
	}
}
