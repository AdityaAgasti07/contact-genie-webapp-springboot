package com.spring.genie.controller;

import com.spring.genie.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.genie.Dao.UserRepository;
import com.spring.genie.entities.User;
import com.spring.genie.service.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private MyService s;

	@RequestMapping("/")
	public String working(Model model) {

		model.addAttribute("title", "Home - Contact Genie");

		return "home";

	}

	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("title", "About - Contact Genie");

		return "about";

	}

	@RequestMapping("/signup")
	public String signUpForm(Model m) {
		m.addAttribute("title", "Register - Contact Genie");
		m.addAttribute("user", new User());

		return "signup";
	}

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerHandler(@ModelAttribute User u, Model m,
			@RequestParam(value = "agreement", defaultValue = "false") boolean b, HttpSession session) {

		try {
			if (!b) {
				System.out.println("box not checked");
				throw new Exception("Box not checked error");
			}

			u.setRole("ROLE_USER");
			u.setEnabled(true);
			u.setImageUrl("default.png");
			System.out.println("agreement " + b);
			System.out.println(u);
			m.addAttribute("user", u);

			User result = s.saveUser(u);
			m.addAttribute("user", result);
			m.addAttribute("user", new User());
			m.addAttribute("session", session);
			m.addAttribute("message", new Message("Successfully Registered !", "alert-success"));

			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("message", new Message("Something went wrong !" + e.getMessage(), "alert-danger"));
			m.addAttribute("session", session);
			m.addAttribute("user", u);
			return "signup";
		}

	}

}
