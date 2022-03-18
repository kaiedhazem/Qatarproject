package isi.com.Qatar2022.Services;

import java.util.List;

import isi.com.Qatar2022.Entities.User;

public interface IUserService {

	User saveUser(User user);
	List<User> findAllUsers();
	void deleteUser(Long id);
	void addUser(User user);
	
}
