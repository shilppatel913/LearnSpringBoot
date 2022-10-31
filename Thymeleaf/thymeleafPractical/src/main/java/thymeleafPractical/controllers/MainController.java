package thymeleafPractical.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

		@RequestMapping("/home")
		public String home(Model model) {
			System.out.println("Inside home");
			model.addAttribute("name","Shilp Patel");
			return "home";
		}
}
