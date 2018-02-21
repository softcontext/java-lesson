package thread15_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteExample3 {

	public static void main(String[] args) throws InterruptedException {
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("processors = " + processors);
		ExecutorService executorService = Executors.newFixedThreadPool(processors);
		
		// 리턴값이 있는 경우 
		Callable<Integer> callable = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += i;
				}
				return sum;
			}
		};
		
		Future<?> future = executorService.submit(callable);
		
		try {
			int result = (int) future.get();
			System.out.println("result = " + result);
			System.out.println("Done.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		executorService.shutdown();
	}
}
