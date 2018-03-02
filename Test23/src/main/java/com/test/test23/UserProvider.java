package com.test.test23;

import java.util.List;
import com.test.test23.domain.User;
public interface UserProvider {
	public void insertUser(User user);
	public List<User> findAllUsers();
	public User findUser(String userId);
	public User updateUser(String userId,String updateName);
}
