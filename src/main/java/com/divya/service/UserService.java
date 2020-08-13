package com.divya.service;

import java.util.List;

import com.divya.exception.UserNotFoundException;
import com.divya.model.User;

public interface UserService {
	public void createUser(User user);
	public List<User> getUser(String user_ssn);
	public List<String>viewStates();
	public List<User>viewUsers();
	public User findBySsn(String ssn) throws UserNotFoundException;
	public boolean updatedUser(User user ) throws UserNotFoundException;
	public void deletedUser(String ssn);

}
