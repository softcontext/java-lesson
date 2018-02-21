package thread15_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteExample2 {

	public static void main(String[] args) throws InterruptedException {
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("processors = " + processors);
		ExecutorService executorService = Executors.newFixedThreadPool(processors);
		
		// 리턴값이 없는 경우 
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += i;
				}
				System.out.println("sum = " + sum);
			}
		};
		
		// 지연 완료 객체
		Future<?> future = executorService.submit(runnable);
		
		try {
			// 스레드가 작업을 완료해서 리턴할 때까지 대기한다.
			// null을 리턴하면 정상처리
			future.get();
			System.out.println("Done.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		executorService.shutdown();
	}
}
