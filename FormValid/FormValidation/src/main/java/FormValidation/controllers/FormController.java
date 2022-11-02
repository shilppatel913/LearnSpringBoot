package FormValidation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	
	@RequestMapping("/openform")
	public String formOpen() {
		return "form";
	}
}
