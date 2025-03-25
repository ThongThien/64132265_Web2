package ntt.ntu.TongHopGK;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import models.SinhVien;

@Controller
public class HomeControllers {

    private List<SinhVien> danhSachSinhVien = new ArrayList<>();

    public HomeControllers() {
        danhSachSinhVien.add(new SinhVien("SV001", "Nguyen Van A", 8.5));
        danhSachSinhVien.add(new SinhVien("SV002", "Tran Thi B", 7.2));
        danhSachSinhVien.add(new SinhVien("SV003", "Le Van C", 6.8));
    }

    @GetMapping("/")
    public String trangChu() {
        return "frontEndViews/home";
    }

    @GetMapping("/about")
    public String gioiThieu() {
        return "frontEndViews/about";
    }

    @GetMapping("/list")
    public String danhSachSinhVien(Model model) {
        model.addAttribute("dssv", danhSachSinhVien);
        return "frontEndViews/list";
    }

    @GetMapping("/add-new")
    public String hienThiForm(Model model) {
        model.addAttribute("sinhVien", new SinhVien()); 
        return "frontEndViews/addNew";
    }

    @PostMapping("/add-new")
    public String themSinhVien(@ModelAttribute SinhVien sinhVien) {
        danhSachSinhVien.add(sinhVien);
        return "redirect:/list"; 
    }
}
