package ntt.ntu.SendDataToView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class SendDataController {

    @GetMapping("/datatoview")  
    public String SendData(Model model) {
        model.addAttribute("mssv", "64132265");
        model.addAttribute("name", "Nguyễn Thông Thiên");
        model.addAttribute("gt", "Nam");
        model.addAttribute("sn", "08/06/2004");
        
        return "viewInfo";  
    }
}
