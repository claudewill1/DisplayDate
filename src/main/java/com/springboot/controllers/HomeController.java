package com.springboot.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		LocalDateTime date = LocalDateTime.now();
		SimpleDateFormat formatter = new SimpleDateFormat();
		
		model.addAttribute("date",String.format("%s, the %d of %s %d", date.getDayOfWeek(),date.getDayOfMonth(),date.getMonth(),date.getYear()));
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		Date time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
		String formatTime = formatter.format(time);
		model.addAttribute("time", formatTime);
		return "time.jsp";
	}
	
	@GetMapping("/goToHome")
	public String goToHome() {
		return "index.jsp";
	}
}
