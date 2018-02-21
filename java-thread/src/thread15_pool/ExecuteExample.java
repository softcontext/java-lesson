package thread15_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

	public static void main(String[] args) throws InterruptedException {
		// 스레드 풀의 허용 스레드 개수는 2개다.
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					
					System.out.println(poolSize);
					System.out.println(threadName);
					
					// 예외를 발생시켜 해당 스레드를 제거한다.
					int value = Integer.parseInt("One");
					
				}
			};
			
//			executorService.execute(runnable);
			// 작업 처리 결과로 Future를 리턴한다. Future 객체는 작업결과가 아니라 작업이 완료된 후 최종결과를 얻는데 사용한다.
			// 예외가 발생해도 종료되지 않고 다음 작업을 위해 스레드를 재사용한다.
			executorService.submit(runnable);
			
			// 출력 시간을 주기 위해 약간 정지시킨다.
			Thread.sleep(10);
		}
		
		executorService.shutdown();
	}
}
