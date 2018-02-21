package stream01;

public class Fruit {
	private int no;
	private String name;
	private int count;

	public Fruit() {
	}

	public Fruit(int no, String name, int count) {
		this.no = no;
		this.name = name;
		this.count = count;
	}

	@Override
	public String toString() {
		return "{ no:" + no + ", name:" + name + ", count:" + count + " }";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
