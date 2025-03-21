package ntt.ntu.SendDataToView.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DatafromViewtoController {
	
	@GetMapping("/form") 
	public String form() {
		return "form";
	}
	@GetMapping("/about") 
	public String about(
		@RequestParam(name = "mssv") String mssv,
		@RequestParam(name = "school") String school,
		Model model
	) {
		model.addAttribute("mssv",mssv);
		model.addAttribute("school",school);
		return "about";
	}
}
