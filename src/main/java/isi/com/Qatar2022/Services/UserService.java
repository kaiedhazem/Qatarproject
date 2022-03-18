package isi.com.Qatar2022.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.com.Qatar2022.Entities.User;
import isi.com.Qatar2022.Repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	
}
