package sample;

import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		UserController controller = new UserController();

		List<User> users = controller.select();
		for (User u : users) {
			System.out.println(u);
		}

//		User [sno=1, id=id-1, pw=pw-1, name=aa]
//		User [sno=2, id=id-2, pw=pw-2, name=bb]
//		User [sno=3, id=id-3, pw=pw-3, name=cc]
		
		System.out.println("-----------");
		
		User newUser = new User(0, "id-4", "pw-4", "dd");
		
		newUser = controller.insert(newUser);
		System.out.println(newUser);

		System.out.println("-----------");
		
		User user = (User) controller.selectByKey(newUser.getSno());
		System.out.println(user);
		
		System.out.println("-----------");
		
		user.setId("id-44");
		user.setPw("pw-44");
		user.setName("ddd");
		
		user = controller.update(user);
		System.out.println(user);
		
		System.out.println("-----------");
		
		users = controller.delete(user.getSno());
		for (User u : users) {
			System.out.println(u);
		}
		
	}
}
