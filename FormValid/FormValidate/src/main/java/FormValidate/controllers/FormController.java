package FormValidate.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import FormValidate.models.LoginData;

@Controller
public class FormController {

		@RequestMapping("/openform")
		public String formOpen(Model model) {
			model.addAttribute("loginData",new LoginData());
			return "form";
		} 
		 
		@RequestMapping(value = "/process",method =RequestMethod.POST)
		public String formProcess(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result,Model model) {
			
			System.out.println(loginData);
			System.out.println(result); 
			if(result.hasErrors()) {
				System.out.println(result); 
				return "form";
			}
			model.addAttribute("loginData",loginData);
			return "success";
			
		}
}
