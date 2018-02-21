package thread07_wait_notify;

public class DataBox {
	private String data;
	
	/*
	 * java.lang.IllegalMonitorStateException
	 * 
	 * wait(), notify(), notifyAll() 메소드는 synchronized 블록안에서 사용해야 한다.
	 * = 모니터의 owner가 되기 위해서는 synchronized block을 사용하거나 synchronized method를 사용해야만 한다.
	 */
	public synchronized String getData() {
		// data가 null이면 ProducerThread 가 데이터를 설정하지 않은 것으로 판단하여
		// ConsumerThread 는 기다린다. 
		if (this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		String returnValue = data;
		System.out.println("소비자 스레드가 가져간 데이터 = "+returnValue);
		
		// 소비자 스레드가 가져간 후 가져갔음을 알려주기 위해서 값을 null로 셋팅한다.
		data = null;
		
		// 생산자 스레드를 깨운다.
		notify();
		return returnValue;
	}
	
	public synchronized void setData(String data) {
		// data가 null이 아니면 ConsumerThread 가 데이터를 가져가지 않은 것으로 판단하여
		// ProducerThread 는 기다린다. 
		if (this.data != null) {
			try {
				wait();
			} catch (Exception e) {}
		}
		
		this.data = data;
		System.out.println("생산자 스레드가 설정한 데이터 = "+data);
		
		// 소비자 스레드를 깨운다.
		notify();
	}
}
