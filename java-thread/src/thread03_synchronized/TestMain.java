package thread03_synchronized;

public class TestMain {

	public static void main(String[] args) {
		// user1, user2 변수가 가리키는 객체 모두에 calculator 객체를 준다.
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}

}
