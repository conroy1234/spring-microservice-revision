package org.spring.revision.springmicroservicerevision.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.spring.revision.springmicroservicerevision.bean.User;
import org.springframework.stereotype.Component;

@Component
public class UserSReporisitory {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "conroy white", LocalDate.now()));
		users.add(new User(2, "delroy white", LocalDate.now()));
		users.add(new User(3, "stephen white", LocalDate.now()));
		users.add(new User(4, "louise white", LocalDate.now()));
	}

	public List<User> findAll() {
		return users;
	}

	public User saveUser(User user) {
		user.setId(users.size() + 1);
		users.add(user);
		return user;
	}

	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<User> findById2(int id) {
		return users.stream().filter(u -> u.getId() == id).collect(Collectors.toList());
	}

	public User removeUser(int id) {
		Iterator<User> iterator = users.iterator();			
		while (iterator.hasNext()) {			
			if (id!=0) {
				users.remove(iterator.next());
			}
		}
		return iterator.next();

	}
}
