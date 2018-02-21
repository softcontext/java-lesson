package lambda4;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferenceExample {

	public static void main(String[] args) {
		// 파라미터로 받은 객체의 메소드를 사용
		ToIntBiFunction<String, String> function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Hello", "HELLO"));
		
		function = String::compareToIgnoreCase;
		print(function.applyAsInt("Hello", "Hi"));
	}

	public static void print(int order) {
		if (order < 0) {
			System.out.println("front");
		} else if (order == 0) {
			System.out.println("equal");
		} else {
			System.out.println("back");
		}
	}
}
