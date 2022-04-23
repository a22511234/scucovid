package com.example.scucovid.reop;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scucovid.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
