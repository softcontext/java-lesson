package thread07_wait_notify_review;

public class SynchronizedBlockExample {
	private String data;

	public static void main(String[] args) {
		SynchronizedBlockExample dataBox = new SynchronizedBlockExample();

		ProducerThread pt = new ProducerThread(dataBox);
		ConsumerThread ct = new ConsumerThread(dataBox);

		pt.start();
		ct.start();
	}

	public static class ProducerThread extends Thread {
		private SynchronizedBlockExample dataBox;

		public ProducerThread(SynchronizedBlockExample dataBox) {
			this.dataBox = dataBox;
		}

		@Override
		public void run() {
			// synchronized block 안으로 진입한 쓰레드는 괄호 안에 넣은 객체의 모니터의 owner가 된다.
			for (int i = 0; i < 3; i++) {
				synchronized (dataBox) {
					if (dataBox.data != null) {
						try {
							dataBox.wait();
						} catch (Exception e) {
						}
					}
//					while (dataBox.data != null) {
//						try {
//							dataBox.wait();
//						} catch (Exception e) {
//						}
//					}

					dataBox.data = "Data #" + (i + 1);
					System.out.println("생산자 스레드가 설정한 데이터 = " + dataBox.data);

					// 소비자 스레드를 깨운다.
					dataBox.notify();
				}

			}
		}
	}

	public static class ConsumerThread extends Thread {
		private SynchronizedBlockExample dataBox;

		public ConsumerThread(SynchronizedBlockExample dataBox) {
			this.dataBox = dataBox;
		}

		@Override
		public void run() {
			// IllegalMonitorException is thrown to indicate that
			// a thread has attempted to wait on an object's monitor
			// or to notify other threads waiting on an object's monitor without
			// owning the specified monitor.
			for (int i = 0; i < 3; i++) {
				synchronized (dataBox) {
					if (dataBox.data == null) {
						try {
							dataBox.wait();
						} catch (InterruptedException e) {
						}
					}
//					while (dataBox.data == null) {
//						try {
//							dataBox.wait();
//						} catch (InterruptedException e) {
//						}
//					}

					String returnValue = dataBox.data;
					System.out.println("소비자 스레드가 가져간 데이터 = " + returnValue);

					// 소비자 스레드가 가져간 후 가져갔음을 알려주기 위해서 값을 null로 셋팅한다.
					dataBox.data = null;

					// 생산자 스레드를 깨운다.
					dataBox.notify();
				}

			}
		}
	}
}
