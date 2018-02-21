package util;

public class TypeofExample {

	public static void main(String[] args) {

		int number = 7;
		System.out.println(isPrimitive(number) ? typeof(number) : "Object");

		TypeofExample example = new TypeofExample();

		if (isPrimitive(example)) {
			System.out.println(typeof(example));
		} else {
			System.out.println("Object");
		}

	}

	public static boolean isPrimitive(Object obj) {
		Class<? extends Object> type = obj.getClass();

		if (type == Double.class || type == Float.class || type == Long.class || type == Integer.class
				|| type == Short.class || type == Character.class || type == Byte.class || type == Boolean.class) {
			return true;
		}

		return false;
	}

	public static String typeof(Object obj) {
		String type = obj.getClass().getTypeName();
		type = type.replaceAll("java.lang.", "");
		return type;
	}

}
