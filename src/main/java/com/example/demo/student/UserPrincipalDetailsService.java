package com.example.demo.student;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService{

	private UserRepository userRepo;
	public UserPrincipalDetailsService(UserRepository userRepo) {
		this.userRepo=userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepo.findByUsername(username);
		UserPrincipal userPrinciple= new UserPrincipal(user);
		return userPrinciple;
	}

}
