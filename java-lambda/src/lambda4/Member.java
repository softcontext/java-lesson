package lambda4;

public class Member {
	private String name;
	private String id;

	public Member() {
	}

	public Member(String id) {
		this.id = id;
	}

	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "{" + name + "," + id + "}";
	}
}
