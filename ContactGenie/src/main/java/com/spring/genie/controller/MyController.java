package com.spring.genie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.genie.Dao.UserRepository;
import com.spring.genie.entities.User;

@Controller
public class MyController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/")
	public String working(Model model) {
//		User u=new User();
		/*
		 * u.setAbout("iam a programmer"); u.setEmail("aka@gmail.com"); u.setId(4354);
		 * u.setName("Deogiri"); u.setPassword("akashsky"); userRepo.save(u);
		 */
		model.addAttribute("title", "Title Sky");
		// User u= new User()
		return "home";

	}
	
	@RequestMapping("/signup")
	public String signUpForm() {
		return "signup";
	}

}
