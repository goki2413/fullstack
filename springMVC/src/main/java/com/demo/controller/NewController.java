package com.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;


@Controller
public class NewController {
@GetMapping(value="/loginfirst")
public String first(Model model){
	User user=new User();
	model.addAttribute("logindetail",user );
	return "springlogin";	
	
}
@PostMapping(value="/login")
public String sec(@Valid @ModelAttribute("logindetail") User user,BindingResult result,Model model){
	
	{
		
		if(result.hasErrors())
			return "springlogin";
		else
			return "successlogin";
	}
	
	
		
	
}	
	
	
	
	
	
}
