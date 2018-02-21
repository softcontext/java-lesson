package lambda2;

import java.util.function.IntBinaryOperator;

// 연산 결과를 리턴
public class OperatorExample {
	
	private static int[] scores = { 90, 80, 70 };

	// IntBinaryOperator : 두 개의 int 연산
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];

		for (int score : scores) {
			// int applyAsInt(int, int)
			result = operator.applyAsInt(result, score);
		}

		return result;
	}

	public static void main(String[] args) {
		// 최대값 구하기
		int max = maxOrMin((a, b) -> {
			if (a >= b) {
				return a;
			} else {
				return b;
			}
		});

		System.out.println("max = " + max);

		// 최소값 구하기
		int min = maxOrMin((a, b) -> {
			if (a <= b) {
				return a;
			} else {
				return b;
			}
		});

		System.out.println("min = " + min);
	}
}
