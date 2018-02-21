package thread15_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteExample4 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		class Task implements Runnable {
			Result result;

			Task(Result result) {
				this.result = result;
			}

			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += i;
				}
				result.addValue(sum);
			}
		}

		Result result = new Result();
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);

		// 작업결과를 담을 객체를 두 번째 파라미터로 전달한다.
		Future<?> future1 = executorService.submit(task1, result);
		Future<?> future2 = executorService.submit(task2, result);

		try {
			System.out.println("future1.get() = " + ((Result)future1.get()).result);
//			System.out.println("future2.get() = " + ((Result)future2.get()).result);

			System.out.println("result = " + result.result);
			System.out.println("Done.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		executorService.shutdown();
	}
}

class Result {
	int result;

	synchronized void addValue(int value) {
		result += value;
	}
}
