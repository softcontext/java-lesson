package stream04;

import stream01.Fruit;
import stream01.FruitManager;

public class StreamPipelineExample {

	public static void main(String[] args) {
		/*
		 * FruitManager.fruits.stream() : 오리지널 스트림
		 * filter(f -> f.getCount() >= 10) : 필터링
		 * mapToInt(Fruit::getCount) : 매핑
		 * sum() : 집계
		 */
		
		// 메소드 리턴 타입이 스트림이라면 중간 처리 메소드이고
		// 기본 타입이거나 OptionalXXX라면 최종 처리 메소드이다.
		int sum = FruitManager.fruits.stream()
				.filter(f -> f.getCount() >= 10).mapToInt(Fruit::getCount).sum();

		System.out.println("개수가 10개 이상인 과일들의 합계, sum =" + sum);
	}

}
