package lambda3;

import java.util.function.Predicate;

public class PredicateIsEqualExample {

	public static void main(String[] args) {
		Predicate<String> predicate;
		
		predicate = Predicate.isEqual("Hello");
		// 두 문자열이 같은지 체크한다.
		System.out.println(predicate.test("Hello"));
	}

}
