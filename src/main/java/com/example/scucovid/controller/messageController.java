package com.example.scucovid.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.scucovid.entity.Message;
import com.example.scucovid.reop.MessageRepo;

@Controller
public class messageController {
	@Autowired
	MessageRepo messagerepo;
	
	@PostMapping("/message.save")
	public String submit(@ModelAttribute("Message") Message message, Model model) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    message.setCreatedatetime(formattedDate);
	    System.out.print(formattedDate);
	    if(message.getName().equals("")) {
	    	message.setName("東吳大學");
	    }
	    System.out.print(message.getName());
		messagerepo.saveAndFlush(message);
		return "redirect:/";
	}

}
