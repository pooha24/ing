package type.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import type.model.WebSocketMap;
import type.service.GreetService;
import type.service.JoinService;

@Controller
public class NavController {
	
	@Autowired
	GreetService greetService;
	
	@Autowired
	JoinService joinservice;
	
	@Autowired
	WebSocketMap sessions;
	

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
			List<WebSocketSession> s = sessions.get(session.getId());
			for(WebSocketSession ws : s) {
				ws.sendMessage(new TextMessage(""));
			}
			
			return "redirect:/";
			}
			throw new Exception();
		}catch(Exception e) {
		
			model.addAttribute("error","ID가 이미 있거나 등록된 E-Mail 입니다.");
				return "join";
			
		}
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String loginHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "login";
	}
}
