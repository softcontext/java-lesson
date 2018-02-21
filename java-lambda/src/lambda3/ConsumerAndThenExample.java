package lambda3;

import java.util.function.Consumer;

import common.Person;

public class ConsumerAndThenExample {

	public static void main(String[] args) {
		Consumer<Person> consumerA = (m) -> System.out.println(m.getName());
		Consumer<Person> consumerB = (m) -> System.out.println(m.getAge());

		Consumer<Person> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new Person("aa", 10));
	}

}
