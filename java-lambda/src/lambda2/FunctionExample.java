package lambda2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import common.Person;

// 타입변환
public class FunctionExample {

	private static List<Person> list = new ArrayList<Person>();

	static {
		list.add(new Person("aa", 11));
		list.add(new Person("bb", 22));
		list.add(new Person("cc", 33));
	}

	// Function<T, R> : 객체 T를 객체 R로 매핑
	public static void printString(Function<Person, String> function) {
		for (Person person : list) {
			// R apply(T)
			System.out.println(function.apply(person) + " ");
		}
	}

	// ToIntFunction<T> : 객체 T를 int로 매핑
	public static void printInt(ToIntFunction<Person> function) {
		for (Person person : list) {
			// int applyAsInt(T)
			System.out.println(function.applyAsInt(person) + " ");
		}
	}

	public static void main(String[] args) {
		printString(t -> t.getName());

		printInt(t -> t.getAge());
	}

}
