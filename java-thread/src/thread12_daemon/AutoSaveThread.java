package thread12_daemon;

public class AutoSaveThread extends Thread {

	// 메인 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드를 데몬 스레드라고 한다.
	// 적용 예로 자동 저장, 음악 재생 등이 있다.
	public void save() {
		System.out.println("file saved. Daemon = " + Thread.currentThread().isDaemon());
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}

			save();
		}
	}
}
