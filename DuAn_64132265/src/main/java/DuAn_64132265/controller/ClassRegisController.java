package DuAn_64132265.controller;

import DuAn_64132265.entity.ClassRegistration;
import DuAn_64132265.service.ClassRegistrationService;
import DuAn_64132265.service.StudentService;
import DuAn_64132265.service.ClassService;
import DuAn_64132265.entity.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/classregister")
public class ClassRegisController {

    @Autowired
    private ClassRegistrationService classRegistrationService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @GetMapping
    public String listRegistrations(Model model) {
        List<ClassRegistration> registrations = classRegistrationService.getAllRegistrations();
        model.addAttribute("registrations", registrations);
        return "classregister/list_registrations";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("registration", new ClassRegistration());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("classes", classService.getAllClasses());
        return "classregister/add_registration";
    }

    @PostMapping("/add")
    public String saveRegistration(@ModelAttribute("registration") ClassRegistration registration,
                                   BindingResult result, Model model) {

        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("classes", classService.getAllClasses());

        if (result.hasErrors()) {
            return "classregister/add_registration";
        }

        // Kiểm tra trùng học viên + lớp
        Optional<ClassRegistration> existed = classRegistrationService.findByStudentAndClass(
            registration.getStudent(), registration.getaClass());
        if (existed.isPresent()) {
            result.rejectValue("student", "error.registration", "Học viên này đã đăng ký lớp này rồi.");
            return "classregister/add_registration";
        }

        // ✅ Lấy lại class từ DB để đảm bảo không bị thiếu dữ liệu
        Integer classId = registration.getaClass().getId();
        Class selectedClass = classService.getClassById(classId);

        if (selectedClass == null) {
            result.rejectValue("aClass", "error.registration", "Không tìm thấy lớp học.");
            return "classregister/add_registration";
        }

        // ✅ Kiểm tra maxStudents
        if (selectedClass.getMaxStudents() == null) {
            result.rejectValue("aClass", "error.registration", "Lớp chưa cấu hình số lượng tối đa.");
            return "classregister/add_registration";
        }

        int currentCount = classRegistrationService.countByClass(selectedClass);
        if (currentCount >= selectedClass.getMaxStudents()) {
            result.rejectValue("aClass", "error.registration", "Lớp đã đủ học viên.");
            return "classregister/add_registration";
        }

        // ✅ Tất cả đều hợp lệ → lưu
        registration.setaClass(selectedClass); // set lại class đã load đầy đủ
        classRegistrationService.saveRegistration(registration);
        return "redirect:/classregister";
    }
    @GetMapping("/delete/{studentId}/{classId}")
    public String deleteRegistration(@PathVariable("studentId") Integer studentId,
                                     @PathVariable("classId") Integer classId) {
        classRegistrationService.deleteByStudentAndClass(studentId, classId);
        return "redirect:/classregister";
    }

}
