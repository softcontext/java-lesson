package lambda4;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferenceExample {

	public static void main(String[] args) {
		// 생성자 참조
		Function<String, Member> function1 = Member::new;
		Member member1 = function1.apply("angel");
		System.out.println(member1);

		BiFunction<String, String, Member> function2 = Member::new;
		Member member2 = function2.apply("name", "id");
		System.out.println(member2);
	}

}
