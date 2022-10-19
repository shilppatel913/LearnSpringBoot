package com.springboot.bootspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
		
	@RequestMapping("/home")
	//@ResponseBody //since no jsp has been configured we will return the string as it is with this annotation
	public String home() {
		return "home";
	}
}
