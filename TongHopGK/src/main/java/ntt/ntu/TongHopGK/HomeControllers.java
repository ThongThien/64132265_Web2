package ntt.ntu.TongHopGK;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @GetMapping("/edit/{id}")
    public String editSinhVien(@PathVariable String id, Model model) {
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMssv().equals(id)) {
                model.addAttribute("sinhVien", sv);
                return "frontEndViews/edit";
            }
        }
        return "redirect:/list";
    }

    @PostMapping("/edit")
    public String updateSinhVien(@ModelAttribute SinhVien sinhVien) {
        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            if (danhSachSinhVien.get(i).getMssv().equals(sinhVien.getMssv())) {
                danhSachSinhVien.set(i, sinhVien);
                break;
            }
        }
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable String id) {
        danhSachSinhVien.removeIf(sv -> sv.getMssv().equals(id));
        return "redirect:/list";
    }
    
    @GetMapping("/list")
    public String danhSachSinhVien(
            @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
            Model model) {
        
        List<SinhVien> filteredList = danhSachSinhVien;

        if (!keyword.isEmpty()) {
            filteredList = danhSachSinhVien.stream()
                .filter(sv -> sv.getMssv().toLowerCase().contains(keyword.toLowerCase()) ||
                              sv.getHoTen().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        }

        model.addAttribute("dssv", filteredList);
        model.addAttribute("keyword", keyword);

        return "frontEndViews/list";
    }

}
