package net.sw.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {
	
	@RequestMapping("/")
	public String showForm() {
		
		return "redirect:/formParticipantQuiz";
	}

}
