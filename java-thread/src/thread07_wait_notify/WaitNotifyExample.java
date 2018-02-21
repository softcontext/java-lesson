package thread07_wait_notify;

public class WaitNotifyExample {

	/*
	 * ProducerThread 가 데이터를 만들면
	 * ConsumerThread 가 데이터를 소비한다.
	 * 
	 * 만약, ProducerThread 가 데이터를 만들어서 설정하려는데
	 * ConsumerThread 가 데이터를 가져가지 않았다면 ProducerThread는 기다린다.
	 * 
	 * 만약, ConsumerThread 가 데이터를 가져가려는데 
	 * ProducerThread 가 데이터를 설정하지 않았다면 ConsumerThread는 기다린다.
	 */
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread pt = new ProducerThread(dataBox);
		ConsumerThread ct = new ConsumerThread(dataBox);
		
		pt.start();
		ct.start();
	}

}
