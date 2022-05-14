package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.student.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> hello2(){
		return userRepo.findAll();
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public User getById(long id) throws Exception {
		return userRepo.findById(id).orElseThrow(()-> new Exception("Not FOUND"));
	}
	
	public void deleteUser(long id) {
		 userRepo.deleteById(id);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
}
