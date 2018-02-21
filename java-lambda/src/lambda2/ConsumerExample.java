package lambda2;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> consumer = t -> System.out.println(t);
		consumer.accept("소비객체1");

		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + "," + u);
		biConsumer.accept("소비객체1", "소비객체2");

		DoubleConsumer doubleConsumer = d -> System.out.println(d);
		doubleConsumer.accept(3.14);

		ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
		objIntConsumer.accept("소비객체", 777);
	}

}
