package thread05_yield;

public class ThreadA extends Thread {

	public boolean running = true;
	public boolean working = true;
	
	@Override
	public void run() {
		while (running) {
			if (working) {
				System.out.println("ThreadA running...");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					
				}
			} else {
				// 스레드 스스로 처리권한을 행사하지 않고 다른 스레드에게 양보한다.
				// wait() 메소드로 쉬면 다른 스레드가 notify() 메소드로 깨어주어야 다시 RUNNABLE 상태가 되지만 
				// yield() 메소드로 쉬면 다른 스레드의 도움없이 바로 다시 일을 할 수 있다.
				Thread.yield();
			}
		}
		
		System.out.println("ThreadA done.");
	}

}
