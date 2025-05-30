package Ejercicio1.Twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class System {
	private Set<String> screenNames;
	private List<User> users;
	
	public System() {
		this.screenNames = new HashSet<>();
		this.users = new ArrayList<>();
	}
	
	public boolean addUser(User user) {
		if (this.screenNames.contains(user.getScreenName())) {
			return false;
		}
		this.screenNames.add(user.getScreenName());
		return this.users.add(user);
	}
	
	public boolean deleteUser(User user) {
		if (this.users.contains(user)) {
			this.screenNames.remove(user.getScreenName());
			user.deleteTwits();
			return true;
		}
		return false;
	}
}
