package type.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import type.service.GreetService;

@Controller
public class TestController {
	
	@Autowired
	GreetService greetService;
	
	@RequestMapping({"/index","/"})
	public String indexHandle(Model model ) {
		model.addAttribute("ment", greetService.make());
		return "index";
	}
	
}
