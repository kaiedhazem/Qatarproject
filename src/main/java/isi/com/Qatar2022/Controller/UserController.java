package isi.com.Qatar2022.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.com.Qatar2022.Entities.User;
import isi.com.Qatar2022.Services.IUserService;
import isi.com.Qatar2022.Services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	 
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		List<User> liste = userService.findAllUsers();
		return liste;
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}

}
