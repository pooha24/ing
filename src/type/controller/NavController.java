package type.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import type.service.GreetService;

@Controller
public class NavController {
	
	@Autowired
	GreetService greetService;
	

	@RequestMapping("/join")
	public String joinHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "join";
	}
	
	@RequestMapping("/login")
	public String loginHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "login";
	}
}
