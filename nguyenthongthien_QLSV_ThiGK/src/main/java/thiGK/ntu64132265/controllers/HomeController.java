package thiGK.ntu64132265.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132265.models.Student;
import thiGK.ntu64132265.models.Topic;

@Controller
public class HomeController {	
	
    	private List<Topic> topics = Arrays.asList(
            new Topic(1, "AI Development", "Exploring AI and ML", 101, "Research"),
            new Topic(2, "Web Security", "Cybersecurity for web apps", 102, "Security"),
            new Topic(3, "Blockchain Tech", "Decentralized finance systems", 103, "Finance")
        );

    	private List<Student> students = new ArrayList<>(Arrays.asList(
    		    new Student(1, "Nguyễn Thông Thiên", 1),
    		    new Student(2, "Lê Thanh Sơn", 2),
    		    new Student(3, "Trần Minh Tâm", 3)
    		));
;
        
        @GetMapping("/")
        public String dashboard() {
            return "dashboard";  
        }

        @GetMapping("/topic/all")
        public String listTopics(Model model) {
            model.addAttribute("topics", topics);
            return "topic-list";
        }

        @GetMapping("/topic/new")
        public String newTopic(Model model) {
            model.addAttribute("topic", new Topic());
            return "topic-Addnew";
        }

        @PostMapping("/topic/save")
        public String saveTopic(
            @RequestParam String topicName,
            @RequestParam String topicDescription,
            @RequestParam int supervisorID,
            @RequestParam String topicType
        ) {
            Topic newTopic = new Topic(topics.size() + 1, topicName, topicDescription, supervisorID, topicType);
            topics.add(newTopic);
            return "redirect:/topic/all";
        }

        @GetMapping("/topic/view/{id}")
        public String viewTopic(@PathVariable int id, Model model) {
            Optional<Topic> topic = topics.stream().filter(t -> t.getId() == id).findFirst();
            topic.ifPresent(value -> model.addAttribute("topic", value));
            return "topic-View";
        }

        @GetMapping("/topic/delete/{id}")
        public String deleteTopic(@PathVariable int id) {
            topics.removeIf(t -> t.getId() == id);
            return "redirect:/topic/all";
        }
        
        @GetMapping("/student/all")
        public String listStudents(Model model) {
            model.addAttribute("students", students);
            return "student-List";
        }
        
        @GetMapping("/student/new")
        public String newStudent() {
            return "student-Addnew";
        }
        
        @PostMapping("/student/add")
        public String addStudent(@ModelAttribute Student student) {
            student.setId(students.size() + 1); 
            students.add(student);
            return "redirect:/student/all";
        }
        
        @GetMapping("/student/view/{id}")
        public String viewStudent(@PathVariable int id, Model model) {
            Optional<Student> student = students.stream().filter(s -> s.getId() == id).findFirst();
            student.ifPresent(value -> model.addAttribute("student", value));
            return "student-View";
        }

        @GetMapping("/student/delete/{id}")
        public String deleteStudent(@PathVariable int id, Model model) {
            students.removeIf(s -> s.getId() == id);
            return "redirect:/student/all";
        }
        
}
