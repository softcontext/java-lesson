package thread16_wait_notify;

import java.util.Vector;

public class SyncStack {
	private Vector<Character> buffer = new Vector<Character>();

	public synchronized char pop() {
		while (buffer.size() == 0) {
			try {
				System.out.println("stack 대기");
				this.wait();
			} catch (Exception e) {
			}
		}

		Character cr = ((Character) buffer.remove(buffer.size() - 1));
		char c = cr.charValue();
		System.out.println("stack 삭제:" + c);

		return c;
	}

	public synchronized void push(char c) {
		this.notify();
		Character charObj = new Character(c);
		buffer.addElement(charObj);
		System.out.println("stack 삽입:" + c);
	}
}
