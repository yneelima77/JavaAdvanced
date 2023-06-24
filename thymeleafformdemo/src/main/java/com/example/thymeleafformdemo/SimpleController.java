package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimpleController {
	
	   @GetMapping("/login")
	    public String loginForm(Model model) {

	        model.addAttribute("mylogin", new LoginPOJO());
	        return "create-login";
	    }

	    @PostMapping("/save-login")
	    public String saveLoginSubmission(Model model, LoginPOJO mylogin) {
	    	System.out.println(">>>>>> IN saveLoginSubmission");
	    	System.out.println(">>>>>> uname="+mylogin.getUname());
	    	System.out.println(">>>>>> pass ="+mylogin.getPassword());
	        // TODO: 
	    	model.addAttribute("mylogin", mylogin);
	        return "login-result";
	    }

	@GetMapping("/register")
	public String registerForm(Model model) {

		model.addAttribute("mynewuser", new Registar());
		return "create-register";
	}

	@PostMapping("/save-register")
	public String saveRegisterSubmission(Model model, Registar newuser) {
		System.out.println(">>>>>> IN saveLoginSubmission");
		System.out.println(">>>>>> firstname="+newuser.getFirstname());
		System.out.println(">>>>>> lastname ="+newuser.getLastName());
		System.out.println(">>>>>> email ="+newuser.getEmail());
		System.out.println(">>>>>> username="+newuser.getUsername());
		System.out.println(">>>>>> password ="+newuser.getPassword());

		model.addAttribute("mynewuser", newuser);
		return "register-result";
	}



}
