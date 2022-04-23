package com.example.scucovid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.scucovid.entity.User;
import com.example.scucovid.reop.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userrepo;
	
	public User addUser(@RequestBody User user) {
		return userrepo.saveAndFlush(user);
	}
	public List<User> listUser() {
		return userrepo.findAll();
	}
}
