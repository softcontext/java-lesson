package stream02;

import stream01.Fruit;
import stream01.FruitManager;

public class MapAndReduceExample {

	public static void main(String[] args) {
		/*
		 * FruitManager.fruits.stream() : 오리지널 스트림
		 * mapToInt(Fruit::getCount) : 매핑 스트림
		 * average() : 집계
		 */
		
		// Stream<Fruit> ==> IntStream ==> OptionalDouble ==> double
		double avg = FruitManager.fruits.stream()
				.mapToInt(Fruit::getCount) // 중간 처리
				.average() // 최종 처리
				.getAsDouble();
		
		System.out.println("avg = " + avg);

		avg = Math.round(avg * 100d) / 100d;
		System.out.println("avg = " + avg);
	}

}
