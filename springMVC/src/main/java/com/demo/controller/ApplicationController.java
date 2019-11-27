package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Employee;
import com.demo.model.User;
import com.demo.service.UserService;


@Controller
public class ApplicationController {
	@Autowired
	UserService userService;
@RequestMapping(value="/url",method=RequestMethod.GET)	
public String first()
{
	return "Success";
	
}
//@RequestMapping(value="/url2",method=RequestMethod.POST)	
/*public String second(Model model,@RequestParam("x")String param,@RequestParam("pwd")String paramano)*/
/*public String second(Model model,@ModelAttribute Employee emp)
{
	Employee employee=new Employee(1,"vinu");
	model.addAttribute("empdetail", emp);
	model.addAttribute("employee", emp);
	model.addAttribute("employeepwd", emp);
	return "emp";
	
}*/

//@RequestMapping(value="/url2",method=RequestMethod.POST)	
/*public String second(Model model,@RequestParam("x")String param,@RequestParam("pwd")String paramano)*/
/*public ModelAndView second(Model model,@ModelAttribute Employee employee)
{*/
	//Employee employee=new Employee(1,"vinu");
	//model.addAttribute("empdetail", emp);
/*	model.addAttribute("employee", emp);*/
	/*model.addAttribute("employeepwd", emp);*/
	//return new ModelAndView("emp");
	
//}


@RequestMapping(value="/url2",method=RequestMethod.GET)
public ModelAndView meth(Model model,@ModelAttribute User user){
	User obj=userService.readUserById(user.getUserId());
	System.out.println(user.getUserId());
	ModelAndView modelAndView=new  ModelAndView("emp");
	  modelAndView.addObject("userdetail",obj);
	  System.out.println(obj.getUserId());
	return  modelAndView;

}

@GetMapping(value="/url3/{alias}")
public String sec(@PathVariable("alias") int age){
	System.out.println("my age is"+age);
	return"Success";
	
}









}