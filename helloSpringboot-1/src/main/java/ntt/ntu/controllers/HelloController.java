package ntt.ntu.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HelloController {
	@RequestMapping("/chao")
	public String String_Hello() {
		return "helloView";
	}
}
