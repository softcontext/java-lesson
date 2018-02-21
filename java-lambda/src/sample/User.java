package sample;

public class User {
	private int sno;
	private String id;
	private String pw;
	private String name;

	public User() {

	}

	public User(int sno, String id, String pw, String name) {
		super();
		this.sno = sno;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [sno=" + sno + ", id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
