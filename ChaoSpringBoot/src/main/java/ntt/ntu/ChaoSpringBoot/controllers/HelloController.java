package ntt.ntu.ChaoSpringBoot.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller 
public class HelloController {
	@RequestMapping("/chao")
	public String String_Hello(Model model) {
		model.addAttribute("message", "Xin chào từ Spring Boot!");
		return "viewHello";
	}
}


