package common;

import com.google.gson.Gson;

public class Person implements Jsonify {
	private String name;
	private int age;
	private transient Gson gson = new Gson();

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getJson(Object source) {
		return source != null ? gson.toJson(source) : gson.toJson(this);
	}

}
