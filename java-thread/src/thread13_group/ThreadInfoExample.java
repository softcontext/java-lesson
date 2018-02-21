package thread13_group;

import java.util.Map;
import java.util.Set;

import thread12_daemon.AutoSaveThread;

public class ThreadInfoExample {

	public static void main(String[] args) {
		AutoSaveThread ast = new AutoSaveThread();
		ast.setName("AutoSaveThread");
		ast.setDaemon(true);
		ast.start();
		
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		
		for (Thread thread : threads) {
			System.out.println(thread.getName() + ", Daemon = " + thread.isDaemon());
			System.out.println(thread.getThreadGroup().getName());
			System.out.println();
		}
	}
// JVM이 실행되면 system 스레드 그룹을 만들고 운영에 필요한 스레드들을 그룹안에 포함시킨다.	
	
//	Signal Dispatcher, Daemon = true
//	system
//
//	AutoSaveThread, Daemon = true
//	main
//
//	main, Daemon = false
//	main
//
//	Attach Listener, Daemon = true
//	system
//
//	Finalizer, Daemon = true : 가비지 컬렉터
//	system
//
//	Reference Handler, Daemon = true
//	system
}
