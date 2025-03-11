package ntt.ntu.SendDataToView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ntt.ntu.SendDataToView.controllers.Model.User;

import java.util.List;
import java.util.Arrays;

@Controller  
public class SendDataController {

    @GetMapping("/datatoview")  
    public String SendData(Model model) {
        User user = new User("64132265", "Nguyễn Thông Thiên", "Nam", "08/06/2004");
        model.addAttribute("user", user);
        return "viewInfo";  
    }

    @GetMapping("/objecttoview")  
    public String SendListObjectData(Model model) {
        List<User> users = Arrays.asList(
            new User("64132265", "Nguyễn Thông Thiên", "Nam", "08/06/2004"),
            new User("64132266", "Trần Quang Vũ", "Nam", "01/01/2003"),
            new User("64132267", "Bùi Phúc Bình", "Nữ", "12/12/2002"),
            new User("64132268", "Phùng Thanh Độ", "Nam", "05/05/2001"),
            new User("64132269", "Lê Minh Hoàng", "Nam", "07/07/2000"),
            new User("64132270", "Đỗ Quốc Thắng", "Nữ", "10/10/1999")
        );

        model.addAttribute("users", users); 
        return "viewListUser";  
    }
}
