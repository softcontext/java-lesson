package sample;

import java.util.ArrayList;
import java.util.List;

public class UserController {

	private List<User> users = new ArrayList<>();

	public UserController() {
		users.add(new User(1, "id-1", "pw-1", "aa"));
		users.add(new User(2, "id-2", "pw-2", "bb"));
		users.add(new User(3, "id-3", "pw-3", "cc"));
	}

	public User insert(User user) {
		User mUser = users.stream().max((u1, u2)-> Integer.compare(u1.getSno(), u2.getSno())).get();
		user.setSno(mUser.getSno()+1);
		users.add(user);
		return user;
	}

	public User update(User user) {
		int key = user.getSno();
		User target = users.stream().filter(u->u.getSno() == key).findFirst().orElse(null);
		target.setId(user.getId());
		target.setPw(user.getPw());
		target.setName(user.getName());
		return user;
	}

	public List<User> delete(int key) {
		users.remove(users.stream().filter(user->user.getSno() == key).findFirst().orElse(null));
		return users;
	}

	public List<User> select() {
		return users;
	}
	
	public User selectByKey(int key) {
		return users.stream().filter(user->user.getSno() == key).findFirst().orElse(null);
	}
}
