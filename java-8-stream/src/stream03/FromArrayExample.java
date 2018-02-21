package stream03;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import stream01.Fruit;
import stream01.FruitManager;

public class FromArrayExample {

	public static int sum = 0;
	
	public static void main(String[] args) {

		// List<Fruit> ==> Stream<Fruit> ==> Stream<String> ==> Object[]
		Object[] strArray = FruitManager.fruits.stream().map(new Function<Fruit, String>() {
			@Override
			public String apply(Fruit f) {
				return f.getName();
			}
		}).toArray();

		for (Object str : strArray) {
			System.out.println(str);
		}

		System.out.println("-------------");

		// 배열로부터 스트림을 구해서 사용
		Stream<Object> strStream = Arrays.stream(strArray);
		strStream.forEach(str -> System.out.print(str + ","));

		System.out.println();
		System.out.println("-------------");

		int[] intArray = { 1, 2, 3 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(num -> System.out.print(num + ","));

		System.out.println();
		System.out.println("-------------");

		// Local variable sum defined in an enclosing scope must be final or effectively final
		//int sum = 0;
		
		// 숫자 범위로부터 스트림 얻기
		IntStream intStream2 = IntStream.rangeClosed(1, 100);
		intStream2.forEach(num -> sum += num);
		
		System.out.println("sum = " + sum);
	}

}
