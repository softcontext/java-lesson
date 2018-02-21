package thread15_pool;

// 비동기 통신에서 콜백 객체를 만들 때 사용한다.
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample6 {
	private ExecutorService executorService;

	public ExecuteExample6() {
		this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

	// <결과 타입, 첨부 타입>
	private CompletionHandler<Integer, Void> cb = new CompletionHandler<Integer, Void>() {
		// 콜백
		// 스레드가 작업을 완료하면 특정 메소드를 실행하는 기법이다.
		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("failed() called > " + exc.getMessage());
		}
		
		@Override
		public void completed(Integer result, Void attachment) {
			System.out.println("completed() called > " + result);
		}
	};
	
	public void doWork(final String x, final String y) {
		// Runnable 구현 클래스를 작성할 때 콜백 기능을 구현한다.
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					
					cb.completed(result, null);
				} catch (Exception e) {
					cb.failed(e, null);
				}
			}
		};
		
		// 스레드 풀에게 작업요청
		executorService.submit(task);
	}
	
	public void finish(){
		executorService.shutdown();
	}
	
	public static void main(String[] args) throws InterruptedException {

		ExecuteExample6 example = new ExecuteExample6();
		example.doWork("3", "3");
		example.doWork("3", "three");
		example.finish();

	}
}
