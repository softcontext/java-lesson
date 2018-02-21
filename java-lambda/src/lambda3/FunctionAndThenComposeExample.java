package lambda3;

import java.util.function.Function;

public class FunctionAndThenComposeExample {

	public static void main(String[] args) {
		Function<Member, Address> functionA = (m) -> m.getAddress();
		Function<Address, String> functionB = (a) -> a.getCity();
		Function<Member, String> functionAB = functionA.andThen(functionB);

		String city = functionAB.apply(new Member("홍길동", "gildong", new Address("Korea", "Seoul")));
		System.out.println(city);
	}
}
