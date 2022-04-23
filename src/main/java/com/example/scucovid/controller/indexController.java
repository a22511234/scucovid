package com.example.scucovid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.scucovid.entity.Truck;
import com.example.scucovid.entity.User;
import com.example.scucovid.service.TruckService;
import com.example.scucovid.service.UserService;

@Controller
public class indexController {
	@Autowired
	UserService userService;
	@Autowired
	TruckService truckService;

	@GetMapping("/index")
	public String addMemberPage() {
		return "index";
	}

	@GetMapping("/report")
	public String report(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "report";
	}

	@GetMapping("/mapdata")
	public String truck(Model model) {
		List<User> listuser = userService.listUser();
		model.addAttribute("data", listuser);
		List<Truck> listtrack = truckService.listTrack();
		model.addAttribute("data", listuser);
		model.addAttribute("tracklist", listtrack);
		model.addAttribute("count", listuser.size());
		return "mapdata";
	}
}
