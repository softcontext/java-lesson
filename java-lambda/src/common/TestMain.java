package common;

public class TestMain {

	private Person person;

	public TestMain(Person person) {
		if (person == null) {
			person = new Person("홍길동", 18);
		}

		this.person = person;
	}

	public static void main(String[] args) {

		TestMain tm = new TestMain(null);

		String json = tm.person.getJson(null);

		System.out.println(json);
	}

}
