package stream02;

import java.util.stream.Stream;

import stream01.Fruit;
import stream01.FruitManager;

public class ParallelExample {

	public static void print(Object obj) {
		System.out.println(obj + " by " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		Stream<Fruit> stream = FruitManager.fruits.stream();
		// 순차처리
		stream.forEach(ParallelExample::print);

//		{ no:1, name:apple, count:10 } by main
//		{ no:2, name:kiwi, count:20 } by main
//		{ no:3, name:banana, count:5 } by main
		
		System.out.println();

		Stream<Fruit> parallelStream = FruitManager.fruits.parallelStream();
		// 병렬처리
		parallelStream.forEach(ParallelExample::print);
		
//		{ no:2, name:kiwi, count:20 } by main
//		{ no:3, name:banana, count:5 } by main
//		{ no:1, name:apple, count:10 } by ForkJoinPool.commonPool-worker-1
		
		// 병렬 처리 스트림은 main 스레드를 포함해서 ForkJoinPool(스레드 풀)의 작업 스레드들이 병렬적으로 요소를 처리한다.
	}

}
