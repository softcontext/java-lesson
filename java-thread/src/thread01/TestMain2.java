package thread01;

public class TestMain2 {

	public void print(String flag, int tick) {
		System.out.print(flag + tick + " ");
		
		if (tick % 10 == 0) {
			System.out.println();
		}
	}

	public void count(String flag, int max) {
		for (int i = 0; i < max; i++) {
			print(flag, i + 1);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}

	public static void main(String[] args) {
		TestMain2 tm = new TestMain2();
		
		tm.count("A", 10);
		tm.count("B", 10);
		
		System.out.println("Done.");
	}

	// 출력결과 : A를 찍는 루프가 처리된 후에야 B를 찍는 루프가 처리된다.
	// 이는 스레드(일꾼)가 하나이기 때문이다.
//	A1 A2 A3 A4 A5 A6 A7 A8 A9 A10 
//	B1 B2 B3 B4 B5 B6 B7 B8 B9 B10 
//	Done.
}
