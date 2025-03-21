package ntt.ntu.ThymeleafTemplateProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String trangChu() {
        return "frontEndViews/index";
    }

    @GetMapping("/about")
    public String gioiThieu() {
        return "frontEndViews/about";
    }

    @GetMapping("/contact")
    public String lienHe() {
        return "frontEndViews/contact";
    }

    @GetMapping("/products")
    public String sanPham() {
        return "frontEndViews/products";
    }

    @GetMapping("/services")
    public String dichVu() {
        return "frontEndViews/services";
    }

    @GetMapping("/search")
    public String timKiem() {
        return "frontEndViews/search";
    }
}
