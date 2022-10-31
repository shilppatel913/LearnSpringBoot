package thymeleafPractical.controllers;

import java.util.List;

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
		
		//demo to see how to iterate in thymeleaf engine
		@RequestMapping("/about")
		public String about(Model model) {
			System.out.println("Inside about");
			List<String> names=List.of("Niraj","Nishita","Shilp");
			model.addAttribute("names",names);
			return "about";
		}
		//Demonstration of if unless and switch case
		@RequestMapping("/contact")
		public String contact(Model model) {
			System.out.println("Contact");
			model.addAttribute("isActive",true);
			
			//giving the demo of the switch case in thymeleaf
			List<Integer>numbers=List.of(1);
			model.addAttribute("numbers",numbers);
			return "contact";
		}
		//how to include common fragment in a template
		@RequestMapping("/service")
		public String service(Model model) {
			model.addAttribute("title","My name is Shilp");
			return "service";
		}
}
