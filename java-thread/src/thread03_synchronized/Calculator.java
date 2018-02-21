package thread03_synchronized;

public class Calculator {

	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	// synchronized 키워드를 붙이면 범위 연산자 범위는 한 번에 하나의 스레드만 진입할 수 있는 블록화가 적용된다.
	// 블록화를 적용하지 않으면 OS에 의해서 코드 어느 부분에서나 스레드가 RUNNING 상태이다가 RUNNABLE 대기상태가 될 수 있다.
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		
		// synchronized 키워드를 붙이면 각 스레드가 설정한 값을 그대로 출력하지만
		// 붙이지 않으면 뒤에 기동한 스레드가 설정한 값만을 출력한다.
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
