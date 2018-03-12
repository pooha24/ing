package type.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import type.service.GreetService;
import type.service.JoinService;

@Controller
public class NavController {
	
	@Autowired
	GreetService greetService;
	
	@Autowired
	JoinService joinservice;
	

	@RequestMapping(path="/join", method=RequestMethod.GET)
	public String joinHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "join";
	}
	
	@RequestMapping(path="/join", method=RequestMethod.POST)
	public String joinPostHandle(@RequestParam Map<String, String> map,HttpSession session, Model model) {
		
		
		try {
			boolean rst = joinservice.memberJoin(map);
		if(rst) {
			session.setAttribute("id", map.get("id"));
			return "redirect:/";
			}
			throw new Exception();
		}catch(Exception e) {
		
			model.addAttribute("error","ID가 이미 있거나 등록된 E-Mail 입니다.");
				return "join";
			
		}
	}
	
	@RequestMapping("/login")
	public String loginHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "login";
	}
}
