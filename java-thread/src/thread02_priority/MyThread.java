package thread02_priority;

public class MyThread extends Thread {

	public MyThread(String name) {
		// 스레드에 이름을 붙인다.
		setName(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 2000000000; i++) {
			
		}
		System.out.println(getName());
	}
}
