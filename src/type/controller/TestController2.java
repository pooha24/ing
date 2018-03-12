package type.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import type.service.MailService;

@Controller
public class TestController2 {
	
	@Autowired
	MailService mailService;
	
	@RequestMapping("/test/email")
	public void emailTestHandle(@RequestParam String target) {
		
		boolean b = mailService.sendWelcomeMail(target);
		System.out.println("메일 전송 결과 = " + b);
	}
}
