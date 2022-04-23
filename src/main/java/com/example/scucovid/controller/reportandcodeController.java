package com.example.scucovid.controller;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.scucovid.entity.ContactForm;
import com.example.scucovid.entity.Truck;
import com.example.scucovid.entity.User;
import com.example.scucovid.service.TruckService;
import com.example.scucovid.service.UserService;

@Controller
public class reportandcodeController {
	@Autowired
	UserService userService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	TruckService truckService;

	@PostMapping("/reportcode")
	public String submit(@ModelAttribute("User") User user, Model model) {
		System.out.println(user);
		model.addAttribute("user", user);
		Date date = new Date(System.currentTimeMillis());
		user.setCreatedate(date.toString());
		Random rm = new Random();
		int value = rm.nextInt(1000 + 9999) + 9999;
		System.out.print(user.getMethod());
		System.out.print(user.getMail());
		user.setCode(Integer.toString(value));
		model.addAttribute("code", value);
		userService.addUser(user);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("07156145@scu.edu.tw");
		message.setTo(user.getMail());
		message.setSubject("主旨：東吳學生新冠肺炎自主通報地圖驗證碼");
		message.setText("內容：東吳學生新冠肺炎自主通報地圖你好，驗證碼為 : " + Integer.toString(value));
		mailSender.send(message);
		return "reportcode";
	}

	@GetMapping("/track/{code}")
	public String track(@PathVariable(value = "code") String code,Model model) {
		Truck truck = new Truck();
		model.addAttribute("truck", truck);
		model.addAttribute("code", code);
		List<Truck> list = truckService.findbycode(code);
		model.addAttribute("data", list);
		return "track";

	}

	@PostMapping("/save.do/{code}")
	public String savetrack(@PathVariable(value = "code") String code,@ModelAttribute("Truck") Truck truck, Model model) {
		long id = System.currentTimeMillis();
		truck.setId(Long.toString(id));
		truck.setUser_code(code);
		System.out.println(truck.getId());
		System.out.println(code);
		try {
			truckService.addTrack(truck);
			System.out.println(truck.getId() + "成功"+truck.getUser_code());
			model.addAttribute("result", "成功");
			
			Truck trucks = new Truck();
			model.addAttribute("truck", trucks);
			model.addAttribute("code", code);
		} catch (Exception ex) {
			System.out.println(truck.getId() + "失敗");
			Truck trucks = new Truck();
			model.addAttribute("truck", trucks);
		}
		return "redirect:/track/"+code;
	}
	@GetMapping("/del.do/{id}/{code}")
	public String delete(@PathVariable(value = "id") String id,@PathVariable(value = "code") String code,Model model) {
		truckService.delbyid(id);
		return "redirect:/track/"+code;

	}
}
