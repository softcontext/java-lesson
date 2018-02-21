package thread04_state;

public class TargetThread extends Thread {
	
	// NEW : 스레드 객체 생성, start() 메소드가 호출되기 전 상태
	
	@Override
	public void run() {
		
		// RUNNABLE : 실행 대기 상태
		// run() 메소드가 기동했다고 하더라도 코드가 바로 처리되는 것은 아니다.
		
		for (int i = 0; i < 1000000000; i++) {
			// RUNNING : 실행 상태!
		}
		
		try {
			// TIMED_WAITING : 주어진 시간동안 스레드 스스로 대기하는 상태
			// 주어진 밀리세컨드 만큼 코드를 처리하지 않는다는 것을 보장한다.
			// 주어진 밀리세컨드 시간이 지나면 RUNNABLE 상태가 되는 것이지 RUNNING 상태가 바로 되는 것은 아니다.
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		
		// RUNNABLE : 실행 대기 상태
		
		for (int i = 0; i < 1000000000; i++) {
			// RUNNING : 실행 상태!
		}
	}
	
	// TERMINATED : 실행을 마친 상태
}
