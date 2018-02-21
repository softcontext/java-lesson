package thread03_synchronized;

public class User2 extends Thread {
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.setName("Thread User #2");
		
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(200);
	}
}
