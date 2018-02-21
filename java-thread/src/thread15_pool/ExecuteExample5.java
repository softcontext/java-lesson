package thread15_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteExample5 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

		for (int i = 0; i < 3; i++) {
			completionService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i = 0; i < 10; i++) {
						sum += i;
					}
					return sum;
				}
			});
		}

		// 처리 완료된 작업 확인
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						// 완료 작업 가져오기, 요청 순서대로 리턴해 주지 않는다.
						Future<Integer> future = completionService.take();
						int value = future.get();
						System.out.println("value = " + value);
					} catch (Exception e) {
						break;
					}
				}
			}
		});

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		executorService.shutdown();
		System.out.println("Done.");
		
	}
}
