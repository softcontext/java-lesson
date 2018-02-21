package lambda2;

import java.util.function.IntSupplier;

public class SupplierExample {

	public static void main(String[] args) {
		IntSupplier intSupplier = () -> (int) (Math.random() * 6) + 1;
		System.out.println(intSupplier.getAsInt());
	}

}
