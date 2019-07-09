package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

@Controller
@RequestMapping("/hello")
public class firstcontroller{

	@RequestMapping(value="/firstcontroller",method=RequestMethod.GET)
	public String handle(Model model){
		//ModelAndView mv=new ModelAndView();
		model.addAttribute("msg","和是一个字符串");
		return "/first";
	}
	

}
