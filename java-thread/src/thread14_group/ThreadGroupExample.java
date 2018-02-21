package thread14_group;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("myGroup");
		WorkThread wt1 = new WorkThread(tg, "Thread #1");
		WorkThread wt2 = new WorkThread(tg, "Thread #2");
		
		wt1.start();
		wt2.start();
		
		Thread.currentThread().getThreadGroup().list();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		// 스레드 그룹을 대상으로 interrupt() 메소드를 호출하면 그룹 내에 모든 스레드들을 대상으로 일괄 interrupt() 할 수 있다.
		tg.interrupt();
	}
//	java.lang.ThreadGroup[name=main,maxpri=10]
//	    Thread[main,5,main] : [스레드 이름, 우선 순위, 스레드그룹 이름]
//	    java.lang.ThreadGroup[name=myGroup,maxpri=10]
//	        Thread[Thread #1,5,myGroup]
//	        Thread[Thread #2,5,myGroup]
	
//	Thread #1 interrupted
//	Thread #2 interrupted
//	Thread #2 done.
//	Thread #1 done.
}
