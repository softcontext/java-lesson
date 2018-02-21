package stream01;

import java.util.ArrayList;
import java.util.List;

public class FruitManager {
	public static List<Fruit> fruits = new ArrayList<>();

	static {
		fruits.add(new Fruit(1, "apple", 10));
		fruits.add(new Fruit(2, "kiwi", 20));
		fruits.add(new Fruit(3, "banana", 5));
	}
}
