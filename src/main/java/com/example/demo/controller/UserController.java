package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.student.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/list")
	public List<User> hello2(){
		return userService.hello2();
	}
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	@PutMapping("/update")
	public User updateSt(@RequestBody User User) throws Exception {
		User st=userService.getById(User.getId());
		st.setUsername(User.getUsername());
		st.setPassword(User.getPassword());
		st.setIsBlocked(User.getIsBlocked());
		st.setRoles(User.getRoles());
		return userService.addUser(st);
		
	}
}
