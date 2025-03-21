package ntt.ntu.SendDataToView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
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
    // List Object
    private static final List<User> users = Arrays.asList(
            new User("64132265", "Nguyễn Thông Thiên", "Nam", "08/06/2004"),
            new User("64132266", "Trần Quang Vũ", "Nam", "01/01/2003"),
            new User("64132267", "Bùi Phúc Bình", "Nữ", "12/12/2002"),
            new User("64132268", "Phùng Thanh Độ", "Nam", "05/05/2001"),
            new User("64132269", "Lê Minh Hoàng", "Nam", "07/07/2000"),
            new User("64132270", "Đỗ Quốc Thắng", "Nữ", "10/10/1999")
    );
    @GetMapping("/objecttoview")  
    public String SendListObjectData(Model model) {
        model.addAttribute("users", users); 
        return "viewListUser";  
    }
    
    // Nhập User và xem 
    @GetMapping("/form")
    public String showForm() {
        return "userForm";  
    }

    @GetMapping("/about")
    public String about(
            @RequestParam(name = "mssv", required = false, defaultValue = "Khong xac dinh") String mssv,
            @RequestParam(name = "ten", required = false, defaultValue = "Khong xac dinh") String ten,
            @RequestParam(name = "gioiTinh", required = false, defaultValue = "Khong xac dinh") String gioiTinh,
            @RequestParam(name = "namSinh", required = false, defaultValue = "Khong xac dinh") String namSinh,
            Model model) {
        
        model.addAttribute("mssv", mssv);
        model.addAttribute("ten", ten);
        model.addAttribute("gioiTinh", gioiTinh);
        model.addAttribute("namSinh", namSinh);

        return "about"; 
    }
    
    // Login
    @GetMapping("/formLogin")
    public String showFormLogin() {
        return "loginForm";  
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        boolean isValidUser = users.stream().anyMatch(user -> user.getMssv().equals(id));

        if (isValidUser && "1".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("users", users); 
            return "viewListUser"; 
        } else {
            model.addAttribute("message", "Sai MSSV hoặc Password. Vui lòng thử lại!");
            return "loginForm"; 
        }
    }
    
    // bmi
    @GetMapping("/bmi-form")
    public String showBmiForm() {
        return "bmiForm";  
    }

    @PostMapping("/bmi-result")
    public String tinhBmi(
            @RequestParam("weight") double weight,
            @RequestParam("height") double height,
            Model model) {
        
        double bmi = weight / (height * height);
        String tt;

        if (bmi < 18.5) {
        	tt = "Gầy";
        } else if (bmi < 24.9) {
        	tt = "Bình thường";
        } else if (bmi < 29.9) {
        	tt = "Thừa cân";
        } else {
        	tt = "Béo phì";
        }

        model.addAttribute("bmi", String.format("%.2f", bmi));
        model.addAttribute("tt", tt);

        return "bmiResult";  
    }
}
