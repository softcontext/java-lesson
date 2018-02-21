package thread01;

import java.awt.Toolkit;

public class TestMain1 {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// 시간이 오래걸리는 로직이 있다.
		for (int i = 0; i < 5; i++) {
			System.out.println("beep");
			toolkit.beep();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		
		// "beep" 신호를 처리하고 "done." 메시지를 찍는 것은 모두 메인 스레드가 처리하고 있다.
		System.out.println("done.");
	}

}
