package com.example.scucovid.reop;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scucovid.entity.Message;

public interface MessageRepo extends JpaRepository<Message,Integer>{

}
