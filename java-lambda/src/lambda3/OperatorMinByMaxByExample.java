package lambda3;

import java.util.function.BinaryOperator;

import common.Person;

public class OperatorMinByMaxByExample {

	public static void main(String[] args) {
		BinaryOperator<Person> binaryOperator = BinaryOperator
				.maxBy((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		Person person = binaryOperator.apply(new Person("aa", 10), new Person("bb", 20));

		System.out.println(person.getName());

		System.out.println("-----------");

		binaryOperator = BinaryOperator.minBy((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		person = binaryOperator.apply(new Person("aa", 10), new Person("bb", 20));

		System.out.println(person.getName());
	}

}
