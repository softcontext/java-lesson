package thread06_wait_notify;

public class WorkObject {

	/*
	 * 일시정지 상태 3가지
	 * WAITING : wait() 메소드로 다른 스레드의 notify() 알림까지 대기하고 있는 상태
	 * TIMED_WAITING : sleep() 메소드로 정해진 시간만큼 대기하고 있는 상태
	 * BLOCKED : synchronized 키워드로 생긴 동기화 블록안에 있는 다른 스레드가 일을 마칠때까지 대기하고 있는 상태
	 */
	public synchronized void methodA(){
		System.out.println("ThreadA > methodA() called");
		
		// 일시정지(WAITING, TIMED_WAITING, BLOCKED) 상태의 다른 스레드 하나를 RUNNABLE 상태로 만듬
		// obj.wait() 으로 처리했다면, obj.notify()로 호출해야 obj.wait()으로 대기하는 스레드를 깨운다. 
		notify();
		
		try {
			// 현재의 스레드를 WAITING 상태로 만듬
			// wait 코드가 있는 곳에서 Thread.currentThread() 했을 때 나오는 그 Thread.
			wait();
		} catch (InterruptedException e) {
			
		}
	}
	
	public synchronized void methodB(){
		System.out.println("ThreadB > methodB() called");
		
		// obj.nofiy() 메소드는 obj의 wait set에 박혀서 잠자고 있는 Thread를 깨운다. 
		// 여러 놈이 있을 때 notify()는 그 중 아무 놈이나 한 놈을 깨우고, notifyAll()은 전부 깨운다.
		notify();
		
		try {
			/*
			 * A monitor is mechanism to control concurrent access to an object. 간단하게 스레드의 작업대상 객체의 동기화 모니터링 담당!
			 * Monitor prevents Threads 1 and 2 accessing the monitored (synchronized) section at the same time. 
			 * One will start, and monitor will prevent the other from accessing the region before the first one finishes.
			 * A monitor is an entity that possesses both a lock and a wait set. 
			 * In Java, any Object can serve as a monitor.
			 * 
			 * obj.wait이 호출되면(이 예제에서는 obj는 this)
			 * 1. Thread.currentThread() 가 멈춘다.
			 * 2. obj의 wait set에 그 Thread가 들어간다. 나중에 notify() 메소드로 깨울 대상이 된다. notify에 의해서 깨어나면 다시 synchronized 블록 안으로 들어간다
			 * 3. synchronized 로 잡은 monitor의 lock을 푼다. synchronized 블럭에서 빠져나온다. 즉 모니터를 놔 준다.
			 */
			wait();
		} catch (InterruptedException e) {
			
		}
	}
}
