package com.hcl;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.hcl.model.User;

public class UserAuthentication {

	public static Set<User> users = new HashSet<>();
	private User currentUser = null;

	public Boolean login(String userName, String password) {
		AtomicBoolean userExist = new AtomicBoolean(false);
		users.stream().filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password)).findFirst()
				.ifPresent(x ->

				{
					userExist.set(true);
					currentUser = x;
				});
		return userExist.get();
	}

	public static void seedData() {
		users.add(User.builder().userName("kush").password("pass").build());
		users.add(User.builder().userName("kush2").password("pass2").build());

	}

	public void logout() {

		currentUser = null;
	}

}
