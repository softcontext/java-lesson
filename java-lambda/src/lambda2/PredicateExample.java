package lambda2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import common.Person;

public class PredicateExample {
	private static List<Person> list = new ArrayList<>();

	static {
		list.add(new Person("aa", 10));
		list.add(new Person("bb", 20));
		list.add(new Person("cc", 30));
	}

	public static double avg(Predicate<Person> predicate) {
		int count = 0;
		int sum = 0;

		for (Person person : list) {
			if (predicate.test(person)) {
				count++;
				sum += person.getAge();
			}
		}

		return (double) sum / count;
	}

	public static void main(String[] args) {
		double ageAvg = avg(t -> t.getAge() > 10);
		System.out.println("ageAvg = " + ageAvg);
	}
}
