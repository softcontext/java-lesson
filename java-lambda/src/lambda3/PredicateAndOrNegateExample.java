package lambda3;

import java.util.function.IntPredicate;

public class PredicateAndOrNegateExample {

	public static void main(String[] args) {
		IntPredicate predicateA = a -> a % 2 == 0;
		IntPredicate predicateB = a -> a % 3 == 0;

		IntPredicate predicateAB = predicateA.and(predicateB);
		System.out.println("12는 2와 3의 배수인가? " + predicateAB.test(12));

		predicateAB = predicateA.or(predicateB);
		System.out.println("9는 2 또는 3의 배수인가? " + predicateAB.test(9));
		
		System.out.println("9는 홀수인가? " + predicateA.negate().test(9));
	}

}
