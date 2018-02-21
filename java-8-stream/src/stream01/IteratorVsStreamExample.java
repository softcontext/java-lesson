package stream01;

import java.util.Iterator;

/**
 * Stream
 * 자바8에서 추가된 컬렉션의 요소를 하나씩 참조해서 람다식(functional style)으로 처리할 수 있는 반복자이다.
 */
public class IteratorVsStreamExample {
	
	public void print(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {
		Iterator<Fruit> iter = FruitManager.fruits.iterator();

		// 개발자가 직접 반복작업을 제어
		while (iter.hasNext()) {
			Fruit f = iter.next();
			System.out.println(f);
		}

		System.out.println("--------------");

		// 스트림 내부에서 반복작업을 제어
		FruitManager.fruits.stream().forEach(System.out::println);
		
		System.out.println("--------------");
		
		FruitManager.fruits.stream().forEach(f -> {
			System.out.println(f.getName() + ":" + f.getCount());
		});
		
		System.out.println("--------------");
		
		FruitManager.fruits.stream().forEach(new IteratorVsStreamExample()::print);
	}

}
