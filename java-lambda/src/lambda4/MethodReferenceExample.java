package lambda4;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {

	public static void main(String[] args) {
		// static 메소드 참조
		IntBinaryOperator operator = (a, b) -> Calculator.staticAdd(a, b);
		System.out.println(operator.applyAsInt(1, 2));

		operator = Calculator::staticAdd;
		System.out.println(operator.applyAsInt(1, 2));
		
		// instance 메소드 참조
		Calculator calc = new Calculator();
		
		operator = (a, b) -> calc.instanceAdd(a, b);
		System.out.println(operator.applyAsInt(1, 2));
		
		operator = calc::instanceAdd;
		System.out.println(operator.applyAsInt(1, 2));
	}

}
